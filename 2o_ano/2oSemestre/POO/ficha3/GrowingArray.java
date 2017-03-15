public class GrowingArray{
    private Veiculo[] elements;
    private int size;
    private static final int capacidade_inicial = 100;

    public GrowingArray(){
        this.elements = new Veiculo[capacidade_inicial];
        this.size = 0;
    }

    public GrowingArray(int capacidade){
        this.elements = new Veiculo[capacidade];
        this.size = 0;
    }

    public Veiculo get(int ind){
        if (ind < size)
            return elements[ind];
        else return null;
    }

    public void aumentaArray(int size){
        elements = Array.copyOf(elements, size);
        
    }

    public void add(Veiculo v){
        if(size++ >= 0.8 * elements.length){
            aumentaArray(2 * elements.length);
        }
        elements[size] = v;
    }

    public void add(Veiculo v, int i){

    }


}
