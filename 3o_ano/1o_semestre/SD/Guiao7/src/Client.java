import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String [] args) throws IOException{
        Socket sc = new Socket("127.0.0.1", 9999);

        PrintWriter out = new PrintWriter(sc.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        BufferedReader sysRead = new BufferedReader(new InputStreamReader(System.in));

        Thread reader = new Thread(new ClientReader(in));
        reader.start();
        String text;
        while((text = sysRead.readLine()) != null){
            out.println(text);
        }

        sysRead.close();
        in.close();
        out.close();
        sc.close();
    }
}
