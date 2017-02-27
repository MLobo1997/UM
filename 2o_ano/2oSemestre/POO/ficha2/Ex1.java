import java.util.Arrays;

public class Ex1{
    public static void main (String [] argc){
        int []lista = {12 , 2 ,  45, 66, 7, 23,99};
        newschool(lista);
    }
    
   public static void oldschool (int [] lista){
        System.out.println("---Elementos do Array---");
        for(int i = 0; i < lista.length ; i++)
            System.out.println("Elemento nº" + i + " = " + lista[i]);
        System.out.println("------------------------");
   }

   public static void newschool (int[]lista){
       System.out.println(Arrays.toString(lista));
   }
}
