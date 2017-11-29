import java.util.ArrayList;

public class Socio {
    public ArrayList<String> nomes;
    public String modalidade;

    public Socio(String modalidade) {
        nomes = new ArrayList<>();
        this.modalidade = modalidade;
    }
}
