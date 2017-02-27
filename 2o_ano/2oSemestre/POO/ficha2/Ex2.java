import java.util.Arrays;
import java.lang.Integer;
import java.util.Scanner;

public class Ex2{
    public static void main(String [] argc){
        int [] lista = lerArrayInt(5);

        newschool(lista);

        System.out.println("O menor elemento encontra-se no " + minPos(lista));
    }
    private static int[] lerArrayInt(int n){
        int [] lista = new int [n];
        Scanner input = new Scanner(System.in);

        for(int i = 0 ; i < n ; i++){

            System.out.println("Elemento nº" + i + ":");
            lista[i]= input.nextInt();
        }
        return lista;
    }

    private static int minPos(int[] arr){
        int min = Integer.MAX_VALUE;
        int r = -1;
        int i=0;
        for(int val : arr){
            if(val<min){
                r=i;
                min=val;
            }
            i++; 
        }
        return r;

    } 

    public static void newschool (int[]lista){
       System.out.println(Arrays.toString(lista));
   }
}
