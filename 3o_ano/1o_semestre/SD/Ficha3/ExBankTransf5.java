import java.util.concurrent.locks.*;
import java.util.Random;

class Account{
    float value;
    ReentrantLock lock = new ReentrantLock();

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

    public void lock(){
        lock.lock();
    }

    public void unlock(){
        lock.unlock();
    }
}

class Bank{
    private int slots;
    private Account[] av;

    public Bank(int n) 
    { 
        int j;
        slots = n; 
        av = new Account[slots];
        for(int i = 0 ; i < slots ; i++)
            av[i] = new Account();
    }

    public void lock(int i){
        av[i].lock();
    }

    public void unlock(int i){
        av[i].unlock();
    }

    public void put(int i,float a) { 
        lock(i);
        try{
            av[i].put(a);
        }finally{
            unlock(i);
        }
    }

    public void take(int i,float a) {
        lock(i);
        try{
            av[i].take(a);
        }finally{
            unlock(i);
        }
    }

    public float query(int i) { return av[i].query(); } 

    public float sumn(){
        int i;
        for(i = 0 ; i < slots ; i++)
            lock(i);
        try{
            float sum = 0;
            for(Account a : av)
                sum += a.query();
            return sum;
        }finally{
            for(i = 0 ; i < slots ; i++)
                unlock(i);
        }
    }

    public int slots() {
        return slots;
    }

    public void transfer(int creditI, int debitI, float value){
        try{
            if(creditI < debitI){
                lock(creditI);
                lock(debitI);
                put(creditI, value);
                take(debitI, value);
            }else{
                lock(debitI);
                lock(creditI);
                take(debitI, value);
                put(creditI, value);
            }
        }finally{
            unlock(creditI);
            unlock(debitI);
        }
    }

    public int createAccount(float initialBalance){
        int i;
        for(i = 0 ; i < slots ; i++)
            lock(i);
        try{
            av[slots] = new Account(initialBalance);
            lv[slots] = new ReentrantLock();
            return slots;
        }finally{
            slots++;
            for(i = 0 ; i < slots ; i++)
                unlock(i);
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

