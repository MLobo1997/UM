
public class Candidato{
    private String nome;
     
    public Candidato(String nome){
        this.nome = nome;
    }
    
    public Candidato(Candidato a){
        nome = a.getNome();
    }

    public String getNome(){
        return nome; 
    }

    public int compareTo(Candidato c){
        return this.nome.compareTo(c.getNome());
    }
    public Candidato clone(){
        return new Candidato(this); 
    }
}
