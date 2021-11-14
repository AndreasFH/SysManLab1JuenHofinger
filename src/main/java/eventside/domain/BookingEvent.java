package eventside.domain;

import java.time.LocalDate;

import writeside.domain.Room;

public class BookingEvent {
    private String bookingNr;
    private String customerName;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public BookingEvent(String bookingNr, String customerName, Room room, LocalDate startDate, LocalDate endDate) {
        this.bookingNr = bookingNr;
        this.customerName = customerName;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getBookingNr() {
        return bookingNr;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Booking: Customer: " + customerName + " bookingNr: " + bookingNr + " Rooms: " + room.getRoomNr() + " startDate: " + startDate.toString() + " endDate: " + endDate.toString();

    }
}
