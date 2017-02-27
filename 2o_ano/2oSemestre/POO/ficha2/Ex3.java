import java.util.Arrays;
import java.lang.Integer;
import java.util.Scanner;

public class Ex3{
    public static void main(String [] argc){
        int [] lista = new int[10];
        int N=0;
        
        N+=insertDecr(lista, N,2);
        N+=insertDecr(lista, N,10);
        N+=insertDecr(lista, N,1);
        N+=insertDecr(lista, N,9);
        N+=insertDecr(lista, N,4);
        N+=insertDecr(lista, N,11);
        N+=insertDecr(lista, N,5);
        N+=insertDecr(lista, N,3);
        N+=insertDecr(lista, N,0);
        N+=insertDecr(lista, N,5);

        System.out.println(Arrays.toString(lista));
    }

    public static int insertDecr(int[] v, int N, int n){
        int i;
        for(i = 0; i < N && n < v[i] ; i++);
        for(int i2 =N; i2 < N ; i2++)
            v[i2+1] = v[i2];
        v[i]=n;

        return (N+1);
    }

}
