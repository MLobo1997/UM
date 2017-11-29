import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class ChatThread implements Runnable{
    private Socket sc;
    private LinkedList<Message> conversation;
    private static String user;

    public ChatThread(Socket sc, LinkedList<Message> conversation) {
        this.sc = sc;
        this.conversation = conversation;
        user = "";
    }

    private void dumpConversation(PrintWriter out){
        for(Message m : conversation){
            out.println("[" + user + "::" + );
        }
    }

    public void run(){
        try {
            PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            Message m;
            String text;

            out.println("You are connected!");
            out.println("Tell me your name:");
            user = in.readLine();

            out.println("You can now comunicate at free will.");

            while((text = in.readLine()) != null){
                m = new Message(LocalDateTime.now(), user, text);
                conversation.addLast(m);
            }

            in.close();
            out.close();
            sc.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
