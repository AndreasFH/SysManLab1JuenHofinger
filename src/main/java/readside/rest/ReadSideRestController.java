package readside.rest;


import eventside.domain.BookingEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import readside.QueryController;
import readside.ReadSideBookingRepository;
import writeside.domain.Room;


@RestController
public class ReadSideRestController {
  @Autowired
  private ReadSideBookingRepository bookingRepository;

  @Autowired
  private QueryController queryController;

  @PostMapping(value = "/events/makebooking", consumes = "application/json", produces = "application/json")
  public boolean BookRoom(@RequestBody BookingEvent booking) {

    bookingRepository.storeBooking(booking);
    System.out.println("Booking received in readside: " + booking.toString());

    LocalDate startDate = LocalDate.of(2021, 11, 13);
    LocalDate endDate = LocalDate.of(2021, 11, 20);
    System.out.println("Booking Count: " + queryController.getBookings(startDate, endDate).size());

    System.out.println();
    return true;
  }

  @PostMapping
      (value = "/events/cancelbooking", consumes = "application/json", produces = "application/json")

  public boolean cancelBooking(@RequestBody String bookingNr) {
    try {
      System.out.println("Cancel Booking event on readside: " + bookingNr);
      bookingRepository.cancelBooking(bookingNr);
    }
    catch (Exception e) {
      e.getMessage();
      e.printStackTrace();
    }
    return true;
  }

  @GetMapping("/events/getFreeRooms")
  @ResponseBody
  public Room[] getFreeRooms(@RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
      @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to,
      @RequestParam int numberOfPersons) {

    List<Room> rooms = queryController.getFreeRooms(from, to, numberOfPersons);
    Room[] roomsArray = rooms.toArray(new Room[rooms.size()]);
    return roomsArray;
  }

}
