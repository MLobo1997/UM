package Guiao5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer5 {
    private int array[];
    private int size;
    private int elementsNr = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition(), notEmpty =  lock.newCondition();

    public BoundedBuffer5(int size){
        this.size = size;
        array = new int[size];
    }

    public void put(int l){
        lock.lock();
        try {
            while(elementsNr >= size){
                try {
                    notFull.await();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            array[elementsNr] = l;
            elementsNr++;
            notEmpty.signal();
        }
        finally {
            lock.unlock();
        }
    }

    public int get(){
        int r;
        lock.lock();
        try {
            while(elementsNr == 0){
                try{
                    notEmpty.await();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            r = array[elementsNr - 1];
            elementsNr--;
            notFull.signal();
            return r;
        }
        finally {
            lock.unlock();
        }
    }
}
