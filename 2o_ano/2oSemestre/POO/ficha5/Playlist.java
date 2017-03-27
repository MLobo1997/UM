import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Playlist{
    private List<Faixa> faixas;

    public Playlist(){
        this.faixas = new ArrayList<Faixa>();
    }

    public Playlist(List <Faixa> faixas){
        this.faixas = new ArrayList<Faixa>();
        for(Faixa f : faixas)
            this.faixas.add(f.clone());
    }

    public Playlist(Playlist p){
        this(p.getFaixas());
    }

    public List<Faixa> getFaixas(){
        List<Faixa> aux =  new ArrayList<Faixa>();
        for(Faixa f : this.faixas)
            aux.add(f.clone());
        return aux;
    }

    public List<Faixa> getFaixas2(){
        List<Faixa> aux = new ArrayList<Faixa>(this.faixas.size());
        Iterator<Faixa> it = this.faixas.iterator();
        while(it.hasNext()){
            Faixa f;
            f = it.next();
            aux.add(f.clone());
        }
        return aux;
    }

    private void setFaixas(List<Faixa> faixas){
        for(Faixa f : faixas)
            this.faixas.add(f.clone());
    }

    public int numFaixas(){
        return faixas.size();
    }

   public void adicionar(List<Faixa> faixas){
       Iterator<Faixa> it = faixas.iterator();
       while(it.hasNext()){
           Faixa f = it.next();
           if(!this.faixas.contains(f))
               this.faixas.add(f.clone());
       }
   }

   public void adicionarF(List<Faixa> faixas){
       faixas.forEach(f -> { this.faixas.add(f.clone());});
   }

   public int classificacaoSuperiorF(Faixa f){
       return (int) this.faixas.stream()
                    .filter(t -> t.getClassificacao() > f.getClassificacao())
                    .count();
   }
}
