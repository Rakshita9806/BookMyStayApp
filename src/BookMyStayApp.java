import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class BookingHistory{
    private List<Reservation> confirmedReservations;
    public BookingHistory(){
        confirmedReservations = new ArrayList<>();
    }
    public void addReservation(Reservation reservation){
        confirmedReservations.add(reservation);
    }
    public List<Reservation> getConfirmedReservations(){
        return confirmedReservations;
    }
}

class BookingReportService {

    public void generateReport(BookingHistory history) {

        System.out.println("\nBooking History Report\n");

        for (Reservation reservation : history.getConfirmedReservations()) {

            System.out.println("Guest: "
                    + reservation.getGuestName()
                    + ", Room Type: "
                    + reservation.getRoomType());
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Booking History and Reporting");

        BookingHistory history = new BookingHistory();
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));

        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}
