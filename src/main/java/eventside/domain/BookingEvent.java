package eventside.domain;


import java.time.LocalDate;
import java.util.Date;
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

  public void setBookingNr(String bookingNr) {
    this.bookingNr = bookingNr;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }




  @Override
  public String toString() {
    return "Booking: Customer: " + customerName + " bookingNr: " +  bookingNr + " Rooms: " + room.getRoomNr() + " startDate: " +  startDate.toString() + " endDate: " + endDate.toString();

  }
}
