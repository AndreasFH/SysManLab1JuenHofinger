package readside;

import writeside.domain.Booking;
import writeside.domain.Room;

import java.time.LocalDate;
import java.util.List;

public interface IQueryController {
    public List<Booking> getBookings(LocalDate startDate, LocalDate endDate);

    public List<Room> getFreeRooms(LocalDate startDate, LocalDate endDate, int amountPerson);
}
