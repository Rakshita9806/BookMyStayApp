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
public class BookMyStayApp {
    public static void main(String[] args){
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteAvailability = 2;
        System.out.println("Hotel Room Initialization");
        System.out.println("Single Room: ");
        singleRoom.displayRoomDetails();
        System.out.println("Availability: " +singleRoomAvailability+ "\n");
        System.out.println("Double Room: ");
        doubleRoom.displayRoomDetails();
        System.out.println("Availability: " +doubleRoomAvailability+ "\n");
        System.out.println("Suite: ");
        suite.displayRoomDetails();
        System.out.println("Availability: " +suiteAvailability+ "\n");
    }
}
