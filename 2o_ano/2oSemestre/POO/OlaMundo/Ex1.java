import java.util.Scanner;

public class Ex1
{
    public static void main (String[] args){
    
    String nome;
    int saldo;
    Scanner input = new Scanner(System.in);
    
    System.out.println("Nome:");
    nome= input.next();
    System.out.println("Saldo:");
    saldo= input.nextInt();

    System.out.print("O saldo de " + nome + " é " + saldo);
    }
}
