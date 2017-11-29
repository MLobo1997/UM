package Guiao4;

import java.util.Random;

public class Inserter implements Runnable{
    private BoundedBuffer b;
    private final int t;

    public Inserter(BoundedBuffer buf, int t){
        b = buf;
        this.t = t;
    }

    public void run() {
        Random r = new Random();
        int p;

        for(int i = 0 ; i < t ; i++){
            p = r.nextInt(100);
            b.put(p);
        }
    }
}
