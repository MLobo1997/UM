public class HelloRunnable3 implements Runnable{
    int num;

    public void run() {
        System.out.println(num); 
        num = 111;
    }

    public HelloRunnable3(int arg){
        num = arg;
    }
    public static void main(String[] argc){
        
        HelloRunnable3 r = new HelloRunnable3(222);

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        System.out.println("Inicio!");
        t1.start();
        t2.start();
        System.out.println("Depois!");

        try{
            t2.join();
            t1.join();
        }catch(InterruptedException e){}
        System.out.println("Fim!");
    }
}
