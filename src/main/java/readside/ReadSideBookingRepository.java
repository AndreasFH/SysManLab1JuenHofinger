package readside;

import eventside.domain.BookingEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import writeside.domain.Booking;

public class ReadSideBookingRepository {

  private HashMap<String, Booking> bookings = new HashMap<String, Booking>();


  public void storeBooking(BookingEvent bookingEvent){
    Booking booking = mapBookingEventToBooking(bookingEvent);
    bookings.put(booking.getBookingNr(), booking);

  }

  public void cancelBooking(String bookingNr){
    bookings.remove(bookingNr);
  }


  private Booking mapBookingEventToBooking(BookingEvent booking) {
    return new Booking(booking.getBookingNr(), booking.getCustomerName(), booking.getRoom(), booking.getStartDate(), booking.getEndDate() );

  }

  public List getBookings(){
    List<Booking> bookingList = new ArrayList<Booking>(bookings.values());
    return bookingList;
  }

}
