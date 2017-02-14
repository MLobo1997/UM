import java.util.Scanner;
public class Ex5{
    public static void main (String[] args){
        int soma=0, valor;
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Valor:");
            valor = input.nextInt();
            soma += valor;
            if(valor > maior) maior=valor;
            if(valor < menor) menor=valor;
        }while(valor != 0);

        System.out.println("Soma: "+ soma + "\nMaior: " + maior + "\nMenor: " + menor);
    }
}
