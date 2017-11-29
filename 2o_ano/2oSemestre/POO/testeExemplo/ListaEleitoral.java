import java.util.*;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;

public class ListaEleitoral{
    private String partidoPolitico;
    private Set<Candidato> eleitos;
    private List<Candidato> porEleger;

    public ListaEleitoral(String partidoPolitico, Collection<Candidato> candidatos){
        this.partidoPolitico = partidoPolitico; 
        this.eleitos = new TreeSet<Candidato>();
        this.porEleger= candidatos
                        .stream()
                        .map(Candidato::clone)
                        .collect(Collectors.toList());
    }

    public Candidato aEleger() throws NoMoreCandidatosException{
        Candidato c = porEleger.get(0); 
        if(c != null){
            return c.clone(); 
        }
        else
            throw new NoMoreCandidatosException();
    }

    public void elege(){
        try{
            Candidato c = aEleger();
            eleitos.add(c.clone());
            porEleger.remove(0);
        }
        catch(NoMoreCandidatosException e){
             
        }
    }

    public void elege(int n){
        try{
            for(int i = 0 ; i < n ; i++){
                Candidato c = aEleger();
                eleitos.add(c.clone());
                porEleger.remove(0);
            }
        }
        catch(NoMoreCandidatosException e){
        }
    }

    public Collection<Candidato> candidatos(){
        Stream<Candidato> s1, s2; 
        s1 = porEleger.stream();
        s2 = eleitos.stream();
        return  Stream
                .concat(s1,s2)
                .map(Candidato::clone)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
