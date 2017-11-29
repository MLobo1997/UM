import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;
import static java.lang.Long.valueOf;

/**
 * Created by mlobo1997 on 30/05/2017.
 */
public class HotelsInc {
    private TreeMap<Long,Hotel> Hotels;

    public HotelsInc() {
        Hotels = new TreeMap();
    }

    public void addHotel(Hotel h){
        Hotels.put(h.getID(), h.clone());
    }

    public boolean existeHotel(Hotel h){
        return Hotels.containsValue(h);
    }

    public int quantos(){
        return Hotels.size();
    }

    public int quantos(String loc){
        return  (int)   Hotels
                        .values()
                        .parallelStream()
                        .filter(h -> h.getLocal() == loc)
                        .count();
    }

    public Hotel getHotel(String cod){
        Long id = Long.valueOf(cod);

        return Hotels.get(id);
    }

    public List<Hotel> getHoteis(){
       return   Hotels
                .values()
                .parallelStream()
                .map(Hotel::clone)
                .collect(Collectors.toList());
    }
}

