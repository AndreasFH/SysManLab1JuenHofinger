package writeside;

import eventside.domain.BookingEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jdk.jfr.Event;
import org.springframework.stereotype.Component;
import writeside.domain.Booking;
import writeside.domain.Room;

@Component
public class CommandController {

  private EventPublisher eventPublisher = new EventPublisher();

  private HashMap<String, Booking> bookings = new HashMap<String, Booking>();

  public boolean makeBooking(Booking booking) {

    for(Booking b : bookings.values()){
      if( b.getRoom().getRoomNr().equals((booking.getRoom().getRoomNr()))){
        System.out.println("Booking already exists or room is already occupied");
        return false;

      }
    }
    bookings.put(booking.getBookingNr(), booking);
    System.out.println(bookings.keySet());
    eventPublisher.publishMakeBookingEvent(mapBookingToBookingEvent(booking));
    return true;

  }

  public boolean cancelBooking(String bookingNr) {
   if(bookings.containsKey(bookingNr)){
     System.out.println("Existing Bookings before cancel: " + bookings.size());
     bookings.remove(bookingNr);
     System.out.println("Existing Bookings after cancel: " + bookings.size());

     eventPublisher.publishCancelBookingEvent(bookingNr);
     return true;
      }
    return false;
  }

  private BookingEvent mapBookingToBookingEvent(Booking booking) {
   return new BookingEvent(booking.getBookingNr(), booking.getCustomerName(), booking.getRoom(), booking.getStartDate(), booking.getEndDate() );

  }
}

