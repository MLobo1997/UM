package Guiao5;

import java.util.Random;

public class Inserter5 implements Runnable{
    private BoundedBuffer5 b;
    private final int t;

    public Inserter5(BoundedBuffer5 buf, int t){
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
