import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mlobo1997 on 27/06/2017.
 */
public class AgenciaViagens implements Serializable{
    private HashMap<String, Hotel> hoteis;
    private HashMap<String, List<Long>> nifs;

    public void writeHotel(Class<?> coiso, String file) throws IOException{

        List<Hotel> s =     hoteis
                            .values()
                            .stream()
                            .filter(hotel -> hotel.getClass() == coiso && !nifs.get(hotel.getCodigo()).isEmpty())
                            .collect(Collectors.toList());

        if(!s.isEmpty()) {
            try {
                PrintWriter f = new PrintWriter(file);
                for (Hotel h : s) {
                    f.println(h);
                }
                f.flush();
                f.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public AgenciaViagens readFile(String file) {

        try {
            ObjectInputStream f = new ObjectInputStream(new FileInputStream(file));

            this.AgenciaViagens((AgenciaViagens) f.readObject());
            f.close();
        } catch (IOException|ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Hoteis:\n");
        str.append(hoteis);
        str.append("\nNifs:\n");
        str.append(nifs);
        str.append('\n');

        return str.toString();
    }
}
