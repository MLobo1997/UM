import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex3Server {
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(9999);

        Socket cs = ss.accept();

        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        Integer sum = 0;
        String n;
        while ((n = in.readLine()) != null){
            try{
                sum += Integer.parseInt(n);
                out.println("Sum: " + sum);
            }
            catch (NumberFormatException e){
                out.println("Not a number!!!");
            }
        }

        in.close();
        out.close();
        cs.close();
        ss.close();
    }
}
