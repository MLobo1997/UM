import java.lang.Comparable;
/**
 * Created by mlobo1997 on 30/05/2017.
 */
public class Hotel {
    private Long ID;
    private String Local;
    private Integer Cat;//entre 1 e 5
    private Integer AvailableRooms;
    private Integer PricePerRoom;

    public Hotel(Long ID, String local, Integer cat, Integer availableRooms, Integer pricePerRoom) {
        this.ID = ID;
        Local = local;
        Cat = cat;
        AvailableRooms = availableRooms;
        PricePerRoom = pricePerRoom;
    }

    public Hotel(Hotel h){
        this.ID = h.getID();
        Local = h.getLocal();
        Cat = h.getCat();
        AvailableRooms = h.getAvailableRooms();
        PricePerRoom = h.getPricePerRoom();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }


    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public Integer getCat() {
        return Cat;
    }

    public void setCat(Integer cat) {
        Cat = cat;
    }

    public Integer getAvailableRooms() {
        return AvailableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        AvailableRooms = availableRooms;
    }

    public Integer getPricePerRoom() {
        return PricePerRoom;
    }

    public void setPricePerRoom(Integer pricePerRoom) {
        PricePerRoom = pricePerRoom;
    }

    public Integer compareTo(Hotel h){
        return ID.compareTo(h.getID());
    }

    public Hotel clone(){
        return new Hotel(this);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "ID=" + ID +
                ", Local='" + Local + '\'' +
                ", Cat=" + Cat +
                ", AvailableRooms=" + AvailableRooms +
                ", PricePerRoom=" + PricePerRoom +
                '}';
    }
}
