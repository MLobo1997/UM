import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class Chat {
    public static void main(String [] args) throws IOException{
        LinkedList<Message> conversation = new LinkedList<>();
        LinkedList<Socket> sockets = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        ServerSocket ss = new ServerSocket(9999);
        Socket sc;
        Thread t;

        while(true){
            sc = ss.accept();
            sockets.addLast(sc);
            t = new Thread(new ChatThread(sc, conversation, lock, sockets));
            t.start();
        }
    }
}
