import java.io.File;
import java.util.ArrayList;
import org.apache.commons.csv;.

public class Matcher {
    ArrayList<Socio> socios;
    ArrayList<Convidado> convidados;

    public static void main(String [] args){
        File sociosF = new File("~/Desktop/socios.csv");
        File convidadosF = new File("~/Desktop/convidados.csv");

        CSVParser parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
    }
}
