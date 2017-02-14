public class Ex6{
    public static void main(String [] args){
        long valor;
        valor = Integer.parseInt(args[0]);
        System.out.println("O factorial de "+ args[0] + " é " + factorial(valor));
    }
    public static long factorial(long n){
        if (n==1) return 1;
        else return n*factorial(n-1);
    }
}
