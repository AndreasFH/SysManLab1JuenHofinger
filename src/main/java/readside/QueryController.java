package readside;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import writeside.domain.Booking;
import writeside.domain.Room;

@Component
public class QueryController {

  @Autowired
  private ReadSideBookingRepository bookingRepository;

 private List<Room> hotelRooms = new LinkedList<>();

  public List<Booking> getBookings(LocalDate startDate, LocalDate endDate) {
    List<Booking> bookings = new LinkedList<>();
    for (Booking b : bookingRepository.getBookings()) {
      if ((b.getStartDate().isAfter(startDate) || b.getStartDate().isEqual(startDate)) && (
          b.getEndDate().isBefore(endDate) || b.getEndDate().isEqual(endDate))) {
        bookings.add(b);
      }
    }
    return bookings;
  }

  public List<Room> getFreeRooms(LocalDate startDate, LocalDate endDate, int amountPerson) {
    List<Booking> bookings = getBookings(startDate, endDate);
    HashMap<String, Room> freeRooms = createRoomMap();
    for (Booking b : bookings) {
      if(freeRooms.containsKey(b.getRoom().getRoomNr())){
        freeRooms.remove(b.getRoom().getRoomNr());
      }
    }
   List<Room> suitableRooms = new ArrayList<Room>(freeRooms.values());

    suitableRooms.removeIf(r -> r.getRoomSize() < amountPerson);

    return suitableRooms;

  }


  private HashMap<String, Room> createRoomMap()
  {
    HashMap<String, Room> rooms = new HashMap<>();
    for(Room r : hotelRooms){
      rooms.put(r.getRoomNr(), r);
    }
    return rooms;

  }

  public void addRooms(Room r){
    hotelRooms.add(r);
  }

  public void printRooms(){
    for(Room r : hotelRooms){
      System.out.println(r.getRoomNr() + " ");
    }
  }
}
