import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by mlobo1997 on 11/06/2017.
 */
public class Main {
    public static void main(String[] args){
        ConcurrentSkipListMap<Long, Long> map = new ConcurrentSkipListMap<>();

        map.put((long) 3, (long) 3);
        map.put((long) 5, (long) 5);
        map.put((long) 8, (long) 8);
        map.put((long) 1, (long) 1);

        map.values().stream().map(k -> k*2);
        System.out.println(map);
    }
}
