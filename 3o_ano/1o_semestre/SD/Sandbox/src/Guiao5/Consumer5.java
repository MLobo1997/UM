package Guiao5;

public class Consumer5 implements Runnable{
    private BoundedBuffer5 b;
    private final int t;

    public Consumer5(BoundedBuffer5 buf, int t){
        b = buf;
        this.t = t;
    }

    public void run() {
        for(int i = 0 ; i < t ; i++)
            b.get();
    }
}
