import java.util.concurrent.locks.*;
import java.util.Random;

class Account{
    float value;

    public Account() { this.value=0; }
    public Account(float value) { this.value=value; }

    public void put (float a) {
        value+=a;
    }

    public void take (float a) {
        value-=a;
    }

    public float query() {
        return value;
    }
}

class Bank{
    private int slots;
    private ReentrantLock[] lv;
    private Account[] av;

    public Bank(int n)
    {
        int j;
        slots = n;
        av=new Account[slots];
        lv = new ReentrantLock [slots];
    }

    public void put(int i,float a) {
        lv[i].lock();
        try{
            av[i].put(a);
        }finally{
            lv[i].unlock();
        }
    }

    public void take(int i,float a) {
        lv[i].lock();
        try{
            av[i].take(a);
        }finally{
            lv[i].unlock();
        }
    }

    public float query(int i) { return av[i].query(); }

    public float sumn(){
        int i;
        for(i = 0 ; i < slots ; i++)
            lv[i].lock();
        try{
            float sum = 0;
            for(Account a : av)
                sum += a.query();
            return sum;
        }finally{
            for(i = 0 ; i < slots ; i++)
                lv[i].unlock();
        }
    }

    public int slots() {
        return slots;
    }

    public void transfer(int creditI, int debitI, float value){
        if(creditI < debitI){
            put(creditI, value);
            take(debitI, value);
        }else{
            take(debitI, value);
            put(creditI, value);
        }
    }

    public int createAccount(float initialBalance){
        int i;
        for(i = 0 ; i < slots ; i++)
            lv[i].lock();
        try{
            av[slots] = new Account(initialBalance);
            lv[slots] = new ReentrantLock();
            return slots;
        }finally{
            slots++;
            for(i = 0 ; i < slots ; i++)
                lv[i].unlock();
        }
    }
}

class Mover implements Runnable {
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
            b.transfer(f, t, (float) 10);
        }
    }
}

class Adder implements Runnable
{
    Bank b;
    public Adder(Bank banco) { b = banco; }
    public void run(){
        int slots=b.slots();
        int i, tries;
        float sum, lsum = 0;
        for(tries=0; tries<1000000; tries++){
            sum = b.sumn();
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
