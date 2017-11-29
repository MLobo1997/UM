package Guiao4;

public class Blocker {
    private static int N;
    private int n;


    void waits(){
        boolean lastOne = false;

        synchronized (this) {
            n++;
            if(n == N){
                try {
                    lastOne = true;
                    notify();
                    wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        while(n < N){
            try {
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        notify();
        if(lastOne)
            n = 0;
    }
}
