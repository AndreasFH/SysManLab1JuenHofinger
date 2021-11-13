package readside.rest;


import eventside.domain.BookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import readside.ReadSideBookingRepository;

public class ReadSideRestController {
  @Autowired
  private ReadSideBookingRepository bookingRepository;

  @PostMapping(value = "/events/makebooking", consumes = "application/json", produces = "application/json")
  public boolean BookRoom(@RequestBody BookingEvent booking) {

    bookingRepository.storeBooking(booking);
    System.out.println("Booking received in readside: " + booking);
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
