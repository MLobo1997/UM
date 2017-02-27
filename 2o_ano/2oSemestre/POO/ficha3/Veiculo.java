public class Veiculo{
    private String matricula;
    private double kmsTotal;
    private double kmsParcial;
    private double consumoMedio;
    private int capacidade;
    private int conteudo;

    public Veiculo(String matricula, double kmsTotal, double kmsParcial, double consumoMedio, int capacidade, int conteudo){
        this.matricula=matricula;
        this.kmsTotal=kmsTotal;
        this.kmsParcial=kmsParcial;
        this.consumoMedio=consumoMedio;
        this.capacidade=capacidade;
        this.conteudo=conteudo;
    }

    public String getMatricula(){
        return this.matricula;
    }
    
    public double getkmsTotal(){
        return this.kmsTotal;
    }

    public double getkmsParcial(){
        return this.kmsParcial;
    }

    public double getconsumoMedio(){
        return this.consumoMedio;
    }
    public int getcapacidade(){
        return this.capacidade;
    }

    public int getconteudo(){
        return this.conteudo;
    }

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    
    public void setkmsTotal(double kmsTotal){
        this.kmsTotal=kmsTotal;
    }

    public void setkmsParcial(double kmsParcial){
        this.kmsParcial=kmsParcial;
    }

    public void setconsumoMedio(double consumoMedio){
        this.consumoMedio=consumoMedio;
    }
    public void setcapacidade(int capacidade){
        this.capacidade=capacidade;
    }

    public void setconteudo(int conteudo){
        this.conteudo=conteudo;
    }

    public void abastecer(int litros){
        int Cfinal = this.conteudo + litros;
        if(Cfinal > capacidade) this.conteudo=capacidade;
        else this.conteudo = Cfinal;
    }

    public void resetKms(){
        this.kmsParcial=0;
        this.consumoMedio=0;
    }

    public double autonomia(){
        return((this.conteudo/this.consumoMedio)*100);
    }

    public void registarViagem(int kms, double consumo){
        setkmsTotal(getkmsTotal() + kms);
    }

}
