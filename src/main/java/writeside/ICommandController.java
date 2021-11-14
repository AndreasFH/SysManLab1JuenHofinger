package writeside;

import writeside.domain.Booking;

public interface ICommandController {
    public boolean makeBooking(Booking booking);

    public boolean cancelBooking(String bookingNr);
}
