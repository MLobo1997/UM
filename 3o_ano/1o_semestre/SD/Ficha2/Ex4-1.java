import java.util.*;
import java.lang.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;

class Account{
    private Integer id;
    private Integer value;

    public Account(Integer id){
        this.id = id;
        value = 0;
    }

    public synchronized void take(Integer value){
        this.value -= value;
    }

    public synchronized void put(Integer value){
        this.value += value;
    }

    public synchronized Integer query(){
        return value;
    }
}

class Bank{
    private final Integer slots; //nr de contas
    private TreeMap<Integer, Account> accounts; //indice representa a conta e o conteudo o saldo 

    public Bank(Integer N){
        slots = N;
        accounts = new TreeMap<Integer, Account>();
        for(int i = 0 ; i < N ; i++)
            accounts.put(i, new Account(i));
    }

    public void take(Integer index, Integer value){
        accounts.get(index).take(value);
    }

    public void put(Integer index, Integer value){
        accounts.get(index).put(value);
    }

    public Integer query(Integer index){
        return accounts.get(index).query();
    }

    public Integer slots(){
        return slots;
    }

    public void transfer(Integer debit, Integer credit, Integer value){
        synchronized(accounts.get(credit)){
            synchronized(accounts.get(debit)){
                take(debit, value);
                put(credit, value);
            }
        }
    }

    public Integer sum(){
        Integer sum = 0;
        synchronized(accounts){
            Collection<Account> acs = accounts.values();
            for(Account a : acs)
                sum += a.query();
        }
        return sum;
    }
}

class Mover implements Runnable 
{
    Bank b;

    public Mover(Bank b) { this.b = b; }

    public void run(){
        Random rand = new Random();
        Integer slots=b.slots();
        Integer f;
        Integer t, tries;
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
        Integer slots=b.slots();
        Integer sum, i, tries, lsum=0;
        for(tries=0; tries<1000000; tries++)
        { 
            sum=0;
            /*synchronized(b.accounts){
                for (i=0; i<slots; i++)
                {
                    sum+=b.query(i);
                }
            }*/
            sum = b.sum();
            if (lsum!=sum) System.out.println("Total "+sum);
            lsum=sum;
        }
    }
}

class ExBankTransf3 
{
    public static void main(String[] args) 
    {
        Integer N = 10; // Number of accounts
        Bank b = new Bank(N);
        Mover m = new Mover(b);
        Adder c = new Adder(b);

        new Thread(m).start();
        new Thread(c).start();
    }
}
