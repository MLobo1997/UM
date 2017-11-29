import java.io.IOException;
import java.net.ServerSocket;

public class Ex4Server {

    public static void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Thread t;
        int n = 1;

        while(true){
           t = new Thread(new Ex4SumThread(ss.accept(), n));
           t.start();
           n++;
        }
    }
}
