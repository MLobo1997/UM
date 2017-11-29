/**
 * Created by david on 09-10-2017.
 */
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
//finally é para os casos em q se a seccçao do try sair a meio ele faz o finally primeiro antes de ir embora
class Account
{
    int slot;

    public Account() { slot=0; }


    public void put (int a) {
        ReentrantLock l = new ReentrantLock();
        l.lock();
        try {
            slot += a;
        }
        finally {
            l.unlock();
        }
    }

    public  void take (int a) {
        ReentrantLock l = new ReentrantLock();
        l.lock();
        try {
            slot -= a;
        }
        finally {
            l.unlock();
        }
    }

    public int query() {
        ReentrantLock l = new ReentrantLock();
        l.lock();
        try {
        return  slot;
        }
        finally {
            l.unlock();
        }

    }
}

class Bank
{
    final int slots;
    Account[] av;


    public Bank(int n)
    {
        int j;
        slots = n;
        //lv = new ReentrantLOck [slots]
        av=new Account[slots];
        for(j=0; j<slots; j++) { av[j]=new Account(); }
    }

    //public void lock (int i) { lv[i].lock;}

    public void put(int i,int a) { av[i].put(a); }

    public void take(int i,int a) { av[i].take(a); }

    public int query(int i) { return av[i].query(); }

    public int sumn(int i)
    {
        ReentrantLock l = new ReentrantLock();

        l.lock();
        try {
        if (i==slots) return 0;

            return av[i].query() + sumn(i+1);
        }
        finally {
            l.unlock();
        }
    }

    public int slots() { return slots; }

}

class Mover implements Runnable
{
    Bank b;

    public Mover(Bank banco) { b = banco; }

    public void run()
    {
        Random rand = new Random();
        int slots=b.slots();
        int f;
        int t, tries;
        for(tries=0; tries<1000000; tries++)
        {
            f=rand.nextInt(slots); // get one
            while((t=rand.nextInt(slots))==f); // get a distinct other
            if (f < t)   //para não haver deadlock tem que ser bloqueado o menor
            {
                synchronized (b.av[f]) {
                    synchronized (b.av[t]) {
                        b.take(f,10);
                        b.put(t,10);
                    }
                }
            }
            else
            {
                synchronized (b.av[t]) {
                    synchronized (b.av[f]) {
                        b.take(f,10);
                        b.put(t,10);
                    }
                }
            }
        }
    }
}

class Adder implements Runnable
{
    Bank b;
    public Adder(Bank banco) { b = banco; }
    public void run()
    {
        int slots=b.slots();
        int sum, i, tries, lsum=0;
        for(tries=0; tries<1000000; tries++)
        {
            sum=b.sumn(0);
            if (lsum!=sum) System.out.println("Total "+sum);
            lsum=sum;
        }
    }
}



class ExBankTransf5
{

    public static void main(String[] args)
    {
        int N = 10; // Number of accounts
        Bank b = new Bank(N);
        Mover m = new Mover(b);
        Adder c = new Adder(b);

        new Thread(m).start();
        new Thread(c).start();
    }

}