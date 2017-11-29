package Guiao4;

public class BoundedBuffer{
    private int array[];
    private int size;
    private int elementsNr;

    public BoundedBuffer(int size){
        this.size = size;
        array = new int[size];
        elementsNr = 0;
    }

    public synchronized void put(int v){
        try {
            while (elementsNr >= size){
                wait();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        array[elementsNr] = v;
        elementsNr++;
        //System.out.println("Pus     " + v);
        notifyAll();
    }

    public synchronized int get(){
        try{
            while (elementsNr == 0)
                wait();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        try {
            //System.out.println("Consumi " + array[elementsNr - 1]);
            return array[--elementsNr];
        }
        finally {
            notifyAll();
        }
    }
}
