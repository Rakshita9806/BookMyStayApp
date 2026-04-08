import java.util.HashMap;
import java.util.Map;

abstract class Room{
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight){
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this. pricePerNight = pricePerNight;
    }

    public void displayRoomDetails(){
        System.out.println("Beds: " +numberOfBeds);
        System.out.println("Size: " +squareFeet+ " sqft");
        System.out.println("Price per night: " +pricePerNight);
    }
}

class SingleRoom extends Room{
    public SingleRoom(){ super(1,250,1500.0); }
}

class DoubleRoom extends Room{
    public DoubleRoom(){ super(2,400,2500.0); }
}

class SuiteRoom extends Room{
    public SuiteRoom(){ super(3, 750, 5000.0); }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

class RoomSearchService{
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suite
    ){
        Map<String, Integer> availability = inventory.getRoomAvailability();
        System.out.println("Available Rooms:\n");
        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Single") + "\n");
        }
        if (availability.get("Double") > 0) {
            System.out.println("Double Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Double") + "\n");
        }
        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room:");
            suite.displayRoomDetails();
            System.out.println("Available Rooms: " + availability.get("Suite"));
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args){
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();
        System.out.println("Hotel Room Inventory Status\n");
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suite);
    }
}