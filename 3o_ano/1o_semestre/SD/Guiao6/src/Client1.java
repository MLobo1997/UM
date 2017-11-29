import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {
    public static void main(String args[]) throws IOException {
        Socket cs = new Socket("127.0.0.1", 9999);

        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        BufferedReader currentB = new BufferedReader(new InputStreamReader(System.in));
        String current;
        while((current = currentB.readLine()) != null){
            out.println(current);
            System.out.println("got echo: " + in.readLine());
        }

        currentB.close();
        in.close();
        out.close();
        cs.close();
    }
}
