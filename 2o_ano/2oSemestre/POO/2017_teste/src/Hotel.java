import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by mlobo1997 on 27/06/2017.
 */
public abstract class Hotel implements Comparable<Hotel>, Serializable{
    private String codigo;
    private String nome;
    private String localidade;
    private double precoBaseQuarto;
    private int numeroQuartos;
    private int estrelas;

    public Hotel(String codigo, String nome, String localidade, double precoBaseQuarto, int numeroQuartos, int estrelas) {
        this.codigo = codigo;
        this.nome = nome;
        this.localidade = localidade;
        this.precoBaseQuarto = precoBaseQuarto;
        this.numeroQuartos = numeroQuartos;
        this.estrelas = estrelas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public double getPrecoBaseQuarto() {
        return precoBaseQuarto;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public int compareTo(Hotel h){
        return codigo.compareTo(h.getCodigo());
    }
}
