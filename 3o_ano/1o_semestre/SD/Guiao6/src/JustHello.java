import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JustHello {
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(9999);

        Socket cs = ss.accept();

        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        String Hello = "Hello World";

        out.println(Hello);

        out.close();
        cs.close();
        ss.close();
    }
}
