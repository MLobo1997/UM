import javax.swing.text.StyledEditorKit;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by mlobo1997 on 27/06/2017.
 */
public class Faixa implements Comparator<Faixa>, Playable, Comparable<Faixa>{
    private String              nome;
    private String              autor;
    private double              duracao;
    private int                 classificacao;
    private ArrayList<String>   letra;
    private int                 numeroVezesTocada;
    private LocalDateTime       ultimavez;

    public Faixa(Faixa f){
        nome = f.getNome();
        autor = f.getAutor();
        duracao = f.getDuracao();
        classificacao = f.getClassificacao();
        letra = f.getLetra();
        numeroVezesTocada = f.getNumeroVezesTocada();
        ultimavez = f.getUltimavez();
    }

    public Faixa(String nome, String autor, double duracao, int classificacao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime ultimavez) {
        this.nome = nome;
        this.autor = autor;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.letra = letra;
        this.numeroVezesTocada = numeroVezesTocada;
        this.ultimavez = ultimavez;
    }

    public Boolean equal(Object o){
        if (o == null || o.getClass() != this.getClass())
            return false;
        else if(o == this)
            return true;
        else{
            Faixa f = (Faixa) o;
            if(nome.equals(f.getNome())                         &&
               autor.equals(f.getAutor())                       &&
               duracao == f.getDuracao()                        &&
               classificacao == f.getClassificacao()            &&
               letra.equals(f.getLetra())                       &&
               numeroVezesTocada == f.getNumeroVezesTocada()    &&
               ultimavez.equals(f.getUltimavez()))
                return true;
            else
                return false;
        }
    }

    public int compareTo(Faixa f){
        Integer it = numeroVezesTocada;
        Integer other = f.getNumeroVezesTocada();

        return it.compareTo(other);
    }



    public int compare(Faixa f1, Faixa f2){
        return f1.getUltimavez().compareTo(f2.getUltimavez());
    }

    public void play(){
        System.out.println("TOCA");
        //System.audio.play(letra);
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public double getDuracao() {
        return duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public ArrayList<String> getLetra() {
        return letra;
    }

    public int getNumeroVezesTocada() {
        return numeroVezesTocada;
    }

    public LocalDateTime getUltimavez() {
        return ultimavez;
    }

    public Faixa clone(){
        return new Faixa(this);
    }
}
