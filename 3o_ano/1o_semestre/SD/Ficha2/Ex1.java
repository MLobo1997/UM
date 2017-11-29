public class Ex1 implements Runnable{
    Counter counter;
    int I;

    public void run(){
        int i;
        for(i = 0 ; i < I ; i++);

        synchronized (counter) {counter.N += i;}
        System.out.println(((new Double (I) / (double) 1000000)*100) + "%"); 

    }

    public static class Counter{
        Long N;
        public Counter(){
            N = new Long(0);
        }
        public /*synchronized*/ void increment(){
            N++;
        }

        public Long getCounter(){
            return N;
        }
    }

    public Ex1 (Counter arg, int i){
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
        Ex1 r;
        final int N = 1000000;

        int i;
        Thread t[] = new Thread[N];

        for(i = 0 ; i < N ; i++){
            r = new Ex1(c, i);
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
