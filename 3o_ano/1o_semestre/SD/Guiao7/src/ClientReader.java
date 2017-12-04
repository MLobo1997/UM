import java.io.BufferedReader;
import java.io.IOException;

public class ClientReader implements Runnable{
    private BufferedReader in;

    public ClientReader(BufferedReader in){
        this.in = in;
    }

    public void run(){
        String text;
        try {
            while ((text = in.readLine()) != null) {
                System.out.println(text);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Log out!!");
    }

}
