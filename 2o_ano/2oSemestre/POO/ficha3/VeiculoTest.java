public class VeiculoTest{
    public static void main(String [] argc){
        Veiculo carro = new Veiculo("coiso", 1000, 20, 5, 100, 30);
        
        System.out.println(carro.toString());
/*
        carro.registarViagem(100, 3.5);
        System.out.println(carro.getkmsTotal());
        System.out.println(carro.getkmsParcial());
        System.out.println(carro.getconsumoMedio());
        System.out.println(carro.getconteudo());
        System.out.println("Autonomia: " + carro.autonomia());
        */
    }
}
