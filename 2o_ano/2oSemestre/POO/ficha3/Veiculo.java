public class Veiculo{
    private String matricula;
    private double kmsTotal;
    private double kmsParcial;
    private double consumoMedio;
    private int capacidade;
    private double conteudo;

    public Veiculo(String matricula, double kmsTotal, double kmsParcial, double consumoMedio, int capacidade, double conteudo){
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

    public double getconteudo(){
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

    public void setconteudo(double conteudo){
        this.conteudo=conteudo;
    }

    public void abastecer(double litros){
        double Cfinal = this.conteudo + litros;
        if(Cfinal > capacidade) this.conteudo=(double)capacidade;
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
        double l = (getconsumoMedio() * getkmsParcial())/100;
        setkmsTotal(getkmsTotal() + kms);
        setkmsParcial(getkmsParcial() + kms);
        setconsumoMedio(((l + consumo)/getkmsParcial())*100);
        setconteudo(getconteudo() - consumo);
    }

    public double totalCombustivel(double custoLitro){
        return (custoLitro * getkmsParcial() * getconsumoMedio()/100);
    }
}
