package eventside.rest;

import eventside.BookingRepository;
import eventside.domain.BookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingRestController {

  @Autowired
  private BookingRepository bookingRepository;

  @PostMapping(value = "/events/makebooking", consumes = "application/json", produces = "application/json")
  public boolean BookRoom(@RequestBody BookingEvent booking) {

    bookingRepository.makeBooking(booking);
    System.out.println("Booking received: " + booking);
    return true;
  }

  @PostMapping
      (value = "/events/cancelbooking", consumes = "application/json", produces = "application/json")

  public boolean cancelBooking(@RequestBody String bookingNr) {
   try {
     bookingRepository.cancelBooking(bookingNr);
   }
   catch (Exception e) {
     e.getMessage();
     e.printStackTrace();
    }
    return true;
  }
}



