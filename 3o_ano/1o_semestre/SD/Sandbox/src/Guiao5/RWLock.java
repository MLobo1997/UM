package Guiao5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RWLock{
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition canWrite = lock.newCondition();
    private final Condition canRead = lock.newCondition();
    private int nWrite = 0;
    private int nRead = 0;

    public RWLock() {
    }


    public synchronized void readLock() throws InterruptedException{
        while(nRead > 0)
            canRead.await();

        nRead++;
    }

    public synchronized void readUnlock() throws InterruptedException{
        canRead.signalAll();
        nRead--;
    }

    public synchronized void writeLock() throws InterruptedException{
        while (nWrite > 0)
            canWrite.await();

        canWrite.signalAll();
    }

    public void writeUnlock() throws InterruptedException{
        canWrite.signalAll();
    }
}
