package Guiao4;

public class Consumer implements Runnable{
    private BoundedBuffer b;
    private final int t;

    public Consumer(BoundedBuffer buf, int t){
        b = buf;
        this.t = t;
    }

    public void run() {
        for(int i = 0 ; i < t ; i++)
            b.get();
    }
}
