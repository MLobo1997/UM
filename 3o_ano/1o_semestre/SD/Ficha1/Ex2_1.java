public class Ex2_1 implements Runnable{
    Counter counter;
    int I;

    public void run(){
        for(int i = 1 ; i <= I + 1 ; i++)
            counter.increment();
    }

    public static class Counter{
        Integer N;
        public Counter(){
            N = 0;
        }
        public void increment(){
            N++;
        }

        public int getCounter(){
            return N;
        }
    }

    public Ex2_1 (Counter arg, int i){
        counter = arg;
        I = i;

    }

    public void setI (int i){
        I = i;
    }

    public int getI (){
        return I;
    }


    public static void main(String[] argc){
        Counter c = new Counter();
        Ex2_1 r;
        final int N = 100;

        int i;
        Thread t[] = new Thread[N];

        for(i = 0 ; i < N ; i++){
            r = new Ex2_1(c, i);
            t[i] = new Thread(r);
        }

        for(i = 0 ; i < N ; i++)
            t[i].start();

        try{
            for(i = 0 ; i < N ; i++)
                t[i].join();
        }catch(InterruptedException e){}

        System.out.println(c.getCounter());
    }
}
