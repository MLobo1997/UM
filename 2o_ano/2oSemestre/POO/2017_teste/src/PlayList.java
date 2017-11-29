import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mlobo1997 on 27/06/2017.
 */
public class PlayList {
    private String nome;
    private Map<String, List<Faixa>> musicas;

    public List<Faixa> getFaixas(String autor) throws AutorInexistenteException{
        List<Faixa> r = musicas.get(autor);
        if(r == null) throw new AutorInexistenteException();
        return r;
    }

    public double tempoTotal(String autor) throws AutorInexistenteException{
        List<Faixa> list = musicas.get(autor);
        if(list == null) throw new AutorInexistenteException();

        return  list
                .stream()
                .mapToDouble(Faixa::getDuracao)
                .sum();
    }

    public List<Faixa> todasAsFaixas(){
        return  musicas
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Faixa::clone)
                .collect(Collectors.toList());
    }

    /*
    public Map<Integer, List<Faixa>> faixasPorClass(){
        Map<Integer, List<Faixa>> r = new TreeMap<Integer, List<Faixa>>();

        Stream<Faixa> s =   musicas
                            .values()
                            .stream()
                            .flatMap(List::stream)
                            .map(Faixa::clone);
        List<Faixa> tmp;
        Boolean cnt = true;

        while(cnt){
            try{
               final int clas = s.findAny().get().getClassificacao();
               tmp = s.filter(f -> (f.getClassificacao() == clas)).collect(Collectors.toList());
               r.put(clas, tmp);

               s = s.filter(f -> (f.getClassificacao() != clas));
            }
            catch (NoSuchElementException e){
                cnt = false;
            }
        }

        return r;
    }
    */

    public Map<Integer, List<Faixa>> faixasPorClass(){

        //for (List<Faixa> faixa : musicas.values()){
        return  musicas
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Faixa::clone)
                .collect(Collectors.groupingBy(Faixa::getClassificacao));
    }

    public Collection<List<Faixa>> listAll(){
        return musicas.values();
    }

}
