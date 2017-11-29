
/**
 * Write a description of class TesteParque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.TreeSet;
public class TesteParque
{
    public void main (String args[]) {
        Lugar l1 = new Lugar ("75-EM-15", "Lugar 1", 60,false);
        Lugar l2 = new Lugar ("75-GG-66", "Lugar 2", 43,false);
        Lugar l3 = new Lugar ("95-EH-15", "Lugar 3", 64,false);
        Lugar l4 = new Lugar ("88-EM-15", "Lugar 4", 52,false);
        Lugar l5 = new Lugar ("75-HH-15", "Lugar 5", 60,false);
        
        
        
        Parque p1= new Parque();
        
        p1.novoLugar(l1.clone());
        p1.novoLugar(l2.clone());
        p1.novoLugar(l3.clone());
        p1.novoLugar(l4.clone());
        p1.novoLugar(l5.clone());
        
        
        p1.setNome("Parque 1");
        
        System.out.println("\n");
        System.out.println("Imprimir por tempo:");
        TreeSet <Lugar> t= (TreeSet <Lugar>) p1.lugaresOrdenadosPorTempo();
        System.out.println(t.toString());
        
        Lugar l= t.first();
        
        System.out.println(l.toString());
        
        System.out.println(p1.lugaresOrdenadosPorNome().toString());
        
        
        
        
    }
}
