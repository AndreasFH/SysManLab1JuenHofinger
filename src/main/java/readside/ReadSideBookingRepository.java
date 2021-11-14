package readside;

import eventside.domain.BookingEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import writeside.domain.Booking;
import writeside.domain.Room;

@Component
public class ReadSideBookingRepository {

    private HashMap<String, Booking> bookings = new HashMap<String, Booking>();
    private List<Room> hotelRooms = new LinkedList<>();

    public void addRooms(Room r) {
        hotelRooms.add(r);
    }

    public HashMap<String, Room> createRoomMap() {
        HashMap<String, Room> rooms = new HashMap<>();
        for (Room r : hotelRooms) {
            rooms.put(r.getRoomNr(), r);
        }
        return rooms;

    }

    public void printRooms() {
        for (Room r : hotelRooms) {
            System.out.print(r);
        }
        System.out.println();
    }

    public void storeBooking(BookingEvent bookingEvent) {
        Booking booking = mapBookingEventToBooking(bookingEvent);
        bookings.put(booking.getBookingNr(), booking);

    }

    public void cancelBooking(String bookingNr) {
        System.out.println("Readside bookings before cancellation: " + bookings.values());
        System.out.println("cancel number: " + bookingNr);
        bookings.remove(bookingNr);
        System.out.println("Readside bookings after cancellation: " + bookings.values());
        System.out.println("---------------------------------------------");
    }

    private Booking mapBookingEventToBooking(BookingEvent booking) {
        return new Booking(booking.getBookingNr(), booking.getCustomerName(), booking.getRoom(), booking.getStartDate(), booking.getEndDate());

    }

    public List<Booking> getBookings() {
        List<Booking> bookingList = new ArrayList<Booking>(bookings.values());
        return bookingList;
    }

}
