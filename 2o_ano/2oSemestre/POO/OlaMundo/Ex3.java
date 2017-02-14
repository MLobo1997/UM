import java.util.Scanner;

public class Ex3
{
    public static void main(String[] args){
        int i, r=0;
        Scanner input= new Scanner(System.in);
        for(i=0; i<10; i++){
            System.out.println(i+1 + "º valor:");
            if(input.nextInt() > 5) r++;    
        }
        System.out.println(r + " valores superiores a 5");
    }
}
