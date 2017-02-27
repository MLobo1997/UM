public class Complexo{

    private double a;
    private double b;

    public Complexo (double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }

    public void setA(double a){
        this.a=a;
    }

    public void setB(double b){
        this.b=b;
    }

    //metodos exercicio 1
    public Complexo conjugado(){
        //a +bi => a - bi
        double a = this.getA();
        double b = this.getB();
        
        return new Complexo(a, -b);
    }

    public Complexo soma(Complexo comp){
        double a = comp.getA();
        double b = comp.getB();

        double na = this.a + a;
        double nb = this.b + b;

        return new Complexo(na, nb);
    }

    public Complexo produto(Complexo comp){
        double a = comp.getA();
        double b = comp.getB();

        double na = this.a * a - this.b * b;
        double nb = this.b * a + this.a * b; 

        return new Complexo(na,nb);
    }   

    public Complexo reciproco(){
        double na = a/(a*a + b*b); // <=> this.a/(this.a.....
        double nb = b/(a*a + b*b);
        return new Complexo (na, -nb);
    }
}
