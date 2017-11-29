import java.util.*;

class Bank{
    private final int slots; //nr de contas
    private Integer accounts[]; //indice representa a conta e o conteudo o saldo 

    public Bank(int N){
        slots = N;
        accounts = new Integer[slots];
        Arrays.fill(accounts, 0);
    }

    public void take(int index, Integer value){
        synchronized(accounts[index]){
            accounts[index] -= value;
        }
    }

    public void put(int index, Integer value){
        synchronized(accounts[index]){
            accounts[index] += value;
        }
    }

    public Integer query(int index){
            return accounts[index];
    }

    public int slots(){
        return slots;
    }

    public void transfer(Integer debit, Integer credit, Integer value){
        if(credit < debit){
            synchronized(accounts[credit]){
                synchronized(accounts[debit]){
                    take(debit, value);
                    put(credit, value);
                }
            }
        }
        else{
            synchronized(accounts[debit]){
                synchronized(accounts[credit]){
                    take(debit, value);
                    put(credit, value);
                }
            }
        }
    }

    public Integer lsum(){
        Integer sum = 0;
        synchronized(accounts){
            for(Integer n : accounts){
                sum += n;
            }
        }
        return sum;
    }
}

class Mover implements Runnable 
{
    Bank b;

    public Mover(Bank b) { this.b = b; }

    public void run() 
    {
        Random rand = new Random();
        int slots=b.slots();
        int f;
        int t, tries;
        for(tries=0; tries<1000000; tries++){ 
            f=rand.nextInt(slots); // get one
            while((t=rand.nextInt(slots))==f); // get a distinct other. Carefull!
            b.transfer(f,t,10);
        }
    }
}

class Adder implements Runnable 
{
    Bank b;

    public Adder(Bank b) { this.b = b; }

    public void run() 
    {
        int slots=b.slots();
        Integer sum, i, tries, lsum=0;
        for(tries=0; tries<1000000; tries++)
        { 
            sum=0;
            /*synchronized(b){
                for (i=0; i<slots; i++)
                {
                    sum+=b.query(i);
                }
            }*/
            sum = b.lsum();
            if (lsum!=sum) System.out.println("Total "+sum);
            lsum=sum;
        }
    }
}

class ExBankTransf3 
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
