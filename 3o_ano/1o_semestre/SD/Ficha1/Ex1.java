public class Ex1 implements Runnable{
    int num;
    public void run(){
        for(int i = 1 ; i <= num + 1 ; i++)
            System.out.println(i);
    }

    public Ex1 (int arg){
        num = arg;
    }

    public static void main(String[] argc){
        Ex1 r;
        final int N = 10;
        int i;
        Thread t[] = new Thread[N];
        //Integer N = new Integer(argc[1]);
        for(i = 0 ; i < N ; i++)
            t[i] = new Thread(new Ex1(i));

        for(i = 0 ; i < N ; i++)
            t[i].start();

        try{
            for(i = 0 ; i < N ; i++)
                t[i].join();
        }catch(InterruptedException e){}
    }
}
