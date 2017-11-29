import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoopEcho {
    public static void main(String args[]) throws IOException{

        ServerSocket ss = new ServerSocket(9999);
        Socket cs = ss.accept();

        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));;

        String current;
        while ((current = in.readLine()) != null){
            out.println(current);
            System.out.println("echo: " + current);
        }

        in.close();
        out.close();
        cs.close();
        ss.close();
    }
}
