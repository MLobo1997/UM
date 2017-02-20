import java.util.Scanner;
import java.lang.Math;
import java.time.LocalTime;

public class Ex7{

    public static void main(String [] args){
        double valor;
        final long startTime = System.nanoTime(), endTime;

        valor = Integer.parseInt(args[0]);
        System.out.println("O factorial de "+ args[0] + " é " + factorial(valor));

        endTime = System.nanoTime();

        System.out.println("Foi calculado em " +  ((endTime - startTime)/ Math.pow(10,9)) + " segundos");
    }

    public static double factorial(double n){
        if (n==1) return 1;
        else return n*factorial(n-1);
    }
}
