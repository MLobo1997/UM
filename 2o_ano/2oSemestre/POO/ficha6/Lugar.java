
/**
 * Write a description of class Lugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lugar
{

    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente;

    public Lugar (){
        this.matricula= "n/a";
        this.nome = "n/a";
        this.minutos=0;
        //por permanente ou nao???
    }
    
    
    public Lugar (String matricula, String nome, int minutos, boolean permanente){
        this.matricula= matricula;
        this.nome = nome;
        this.minutos=minutos;
        this.permanente = permanente;
    }
    
    
    public Lugar(Lugar l)
    {
        this.matricula=l.getMatricula();
        this.nome=l.getNome();
        this.minutos=l.getMinutos();
        this.permanente=l.getPermanente();
    }

    
    public String getMatricula(){
        return this.matricula;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getMinutos(){
        return this.minutos;
    }
    
    public boolean getPermanente(){
        return this.permanente;
    }
    public Lugar clone(){
        return new Lugar(this);
    }
    public void setMinutos(int m){
        minutos=m;
    }
}
