import java.time.LocalDateTime;

public class tester {
    public static void main (String [] args){
        Message m = new Message(LocalDateTime.now(), "Lobo", "QUE FIXE MANINHO");

        System.out.println(m.toString());
    }
}
