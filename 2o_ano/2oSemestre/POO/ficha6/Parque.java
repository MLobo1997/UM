import java.util.Iterator;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

public class Parque{
    private String nome;
    private Map<String,Lugar> lugares;

    public Parque(){
        this.nome="n/a";
        this.lugares = new TreeMap<>();
    }

    public Parque(String n, Map<String,Lugar> p){
        this.nome = n; 
        this.lugares =new TreeMap<>();

        for(Map.Entry<String,Lugar> l : p.entrySet())
            this.lugares.put(l.getKey(), l.getValue().clone());
    }

    public Map<String,Lugar> getLugares(){
        Map<String,Lugar> p = new TreeMap<>(); 
        Iterator <Map.Entry<String,Lugar>> it = this.lugares.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String,Lugar> e = it.next();
            p.put(e.getKey(), e.getValue().clone());
        }
        return p;
    }

    public Set <String> ocupados(){
        return this.lugares.keySet();
    }

    public void novoLugar(Lugar l){
        this.lugares.put(l.getMatricula(),l); 
    }

    public void removeLugar(String matricula){
        this.lugares.remove(matricula);
    }

    public void alteraTempo(String m, int min){
        Lugar l = this.lugares.get(m);
        this.lugares.remove(m);
        l.setMinutos(min);
        novoLugar(l);
    }

    public int quantidadeMinutos(){
        return
            this.lugares
            .values()
            .stream()
            .mapToInt(l->l.getMinutos())
            .sum();
    }

    public int quantidadeMinutos2(){
        int sum=0;
        for(Lugar l: this.lugares.values()){
            sum += l.getMinutos();
        }
        return sum;
    }
    public List<String> matriculasTempo(int x){
        return
        this.lugares.values().stream()
            .filter(l->l.getMinutos() > x && l.getPermanente())
            .map(Lugar :: getMatricula)
            .collect(Collectors.toList());
    }

    public List<String> matriculasTempo2(int x){
        List <String> nova = new ArrayList <String>();
        for(Lugar l: this.lugares.values()){
            if(l.getMinutos() > x && l.getPermanente()){
                nova.add(l.getMatricula());
            }
        }
        return nova;
    }
}
