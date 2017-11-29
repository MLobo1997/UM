import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex4SumThread implements Runnable{
    private int i;
    private Socket cs;

    public Ex4SumThread(Socket socket, int n){
        cs = socket;
        i = n;
    }
    public void run(){

        try {
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        Integer sum = 0;
        String n;

            while ((n = in.readLine()) != null) {
                try {
                    sum += Integer.parseInt(n);
                    out.println("Sum: " + sum);
                    System.out.println("Client " + i + " requested to sum " + n);
                } catch (NumberFormatException e) {
                    out.println("Not a number!!!");
                    System.out.println("Client " + i + " sent " + '\"' + n + '\"' + " which is not a number");
                }
            }

        in.close();
        out.close();
        cs.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
