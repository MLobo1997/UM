
/**
 * Write a description of class Parque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.Map;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.List;
import java.util.ArrayList;

public class Parque
{
    private String nome;
    private Map <String, Lugar> lugares;
    
    
    public Parque (){
        this.nome = "n/a";
        this.lugares = new TreeMap<>();
    }
    
    public Parque (String n, Map <String, Lugar> p){
        this.nome=n;
        this.lugares= new TreeMap <> ();
        for (Map.Entry<String, Lugar> l: p.entrySet()){
            this.lugares.put(l.getKey(),l.getValue().clone());
        }
    }
    
    
    //construtores por copia
    public Parque (Parque p){
        this.nome=p.getNome();
        this.lugares=p.getLugares();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    
    // a usar iterators
    public Map<String,Lugar> getLugares(){
        Map <String,Lugar> p= new TreeMap();
        Iterator <Map.Entry<String,Lugar>> it=this.lugares.entrySet().iterator();
       
        while (it.hasNext()){
            Map.Entry<String,Lugar> e=it.next(); // tipo a=i++; o a fica com o valor do i, e o i com i++;
            p.put(e.getKey(), e.getValue().clone());
            
        }
        return p;
        }
 
    
    public Map<String,Lugar> getLugares2(){
        Map <String,Lugar> p= new TreeMap <> ();
        this.lugares.entrySet().forEach(f-> {
            p.put(f.getKey(),f.getValue().clone());
        });
        
        return p;
    }
    
    
    public Set <String> lugaresOcupados(){
        return this.lugares.keySet();
    }
    
    public void novoLugar (Lugar l){
        this.lugares.put(l.getMatricula(),l);
    }
    
    public void removeLugar(String matricula){
        this.lugares.remove(matricula);
    }
    
    
    public void alteraTempo (String m, int min){
        Lugar l= this.lugares.get(m);
        this.lugares.remove(m);
        l.setMinutos(min);
        novoLugar(l);
    }
    
    
    //iterador interno
    public int quantidadeMinutos(){
        return
            this.lugares
            .values()
            .stream()
            .mapToInt(l->l.getMinutos())
            .sum();
    }
    
    
    // entrySet quando precisas de chave e valor;
    // values quando precisas do valor;
    // key quando precisas da chave;
    public int quantidadeMinutos2(){
        int sum=0;
        for(Lugar l: this.lugares.values()){
            sum+=l.getMinutos();
        }
        return sum;
    }
    
    
    public boolean existeLugar (String matricula){
        return this.lugares.containsKey(matricula);
    }
    
    public List <String> matriculasTempo (int x){
        return
        this.lugares.values().stream()
        .filter (l-> l.getMinutos()>x && l.getPermanente())
        .map(Lugar::getMatricula)
        .collect(Collectors.toList());
    }
    
    public List <String> matriculasTempo2 (int x){
        List <String> nova = new ArrayList <String> ();
        for (Lugar l: this.lugares.values()){
            if (l.getMinutos() > x && l.getPermanente()){
                nova.add(l.getMatricula());
            }
        
        }
        return nova;
    }
    
    public void setNome (String p1){
        this.nome=p1;
    }
    

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parque:\n");
        for (Lugar l : this.lugares.values()){
            sb.append ( l.toString()).append("\n");
        }
        return sb.toString();
    }
    
    
    public Set<Lugar> lugaresOrdenadosPorTempo(){
        Set <Lugar> t = new TreeSet <> (new ComparadorMinutos());
        for(Lugar l: this.lugares.values()){
            t.add(l.clone());
        }
        return t;
    }
    
    public Set<Lugar> lugaresOrdenadosPorNome(){
        Set <Lugar> t = new TreeSet <> (new ComparadorNome());
        for(Lugar l: this.lugares.values()){
            t.add(l.clone());
        }
        return t;
    }
        
}
