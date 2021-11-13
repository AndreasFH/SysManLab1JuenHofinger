package readside;

import eventside.domain.BookingEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;
import writeside.domain.Booking;

@Component
public class ReadSideBookingRepository {

  private HashMap<String, Booking> bookings = new HashMap<String, Booking>();

  public void storeBooking(BookingEvent bookingEvent){
    Booking booking = mapBookingEventToBooking(bookingEvent);
    bookings.put(booking.getBookingNr(), booking);

  }

  public void cancelBooking(String bookingNr){
    System.out.println("Readside bookings before cancellation: " + bookings.keySet() + "cancel nr: " + bookingNr);
    bookings.remove(bookingNr);
    System.out.println("Readside bookings after cancellation: " + bookings.keySet());

  }

  private Booking mapBookingEventToBooking(BookingEvent booking) {
    return new Booking(booking.getBookingNr(), booking.getCustomerName(), booking.getRoom(), booking.getStartDate(), booking.getEndDate() );

  }

  public List<Booking> getBookings(){
    List<Booking> bookingList = new ArrayList<Booking>(bookings.values());
    return bookingList;
  }

}
