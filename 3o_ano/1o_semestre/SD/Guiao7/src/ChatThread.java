import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class ChatThread implements Runnable{
    private Socket sc;
    private LinkedList<Message> conversation;
    private String user;
    private ReentrantLock lock;
    private LinkedList<Socket> sockets;

    public ChatThread(Socket sc, LinkedList<Message> conversation, ReentrantLock lock, LinkedList<Socket> s) {
        this.sc = sc;
        this.conversation = conversation;
        user = null;
        this.lock = lock;
        sockets = s;
    }

    private void dumpConversation(PrintWriter out){
        for(Message m : conversation){
            out.println(m.toString());
        }
    }

    private void processMessage(String text){
        try {
            PrintWriter out;
            Message m = new Message(LocalDateTime.now(), user, text);
            lock.lock();
            try {
                conversation.addLast(m);
                for(Socket s : sockets){
                    out = new PrintWriter(s.getOutputStream(), true);
                    out.println(m.toString());
                }
            }
            finally {
                lock.unlock();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            Message m;
            String text;

            dumpConversation(out);

            out.println("You are connected!");
            out.println("Tell me your name:");
            user = in.readLine();

            out.println("You can now comunicate at free will.");

            while((text = in.readLine()) != null){
                processMessage(text);
            }

            in.close();
            out.close();
            sc.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            sockets.remove(sc);
        }
    }
}
