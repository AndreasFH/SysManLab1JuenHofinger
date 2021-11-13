package writeside;

import eventside.domain.BookingEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jdk.jfr.Event;
import writeside.domain.Booking;
import writeside.domain.Room;

public class CommandController {

  private EventPublisher eventPublisher = new EventPublisher();

  private HashMap<String, Booking> bookings = new HashMap<String, Booking>();





  public boolean MakeBooking(Booking booking) {

    for(Booking b : bookings.values()){
      if( b.getRoom().getRoomNr().equals((booking.getRoom().getRoomNr()))){
        return false;

      }
    }
    bookings.put(booking.getBookingNr(), booking);
    eventPublisher.publishMakeBookingEvent(mapBookingToBookingEvent(booking));
    return true;

  }

  public boolean CancelBooking(String bookingNr) {
   if(bookings.containsKey(bookingNr)){
     bookings.remove(bookingNr);
     eventPublisher.publishCancelBookingEvent(bookingNr);


      }


    return false;

  }

  private BookingEvent mapBookingToBookingEvent(Booking booking) {
   return new BookingEvent(booking.getBookingNr(), booking.getCustomerName(), booking.getRoom(), booking.getStartDate(), booking.getEndDate() );

  }
}

