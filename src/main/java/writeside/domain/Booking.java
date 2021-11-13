package writeside.domain;

import java.util.Date;

public class Booking {
  private String bookingNr;
      private String customerName;
      private Room room;
      private Date startDate;
      private Date endDate;

  public Booking(String bookingNr, String customerName, Room room, Date startDate, Date endDate) {
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



  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "Booking: Customer: " + customerName + "bookingNr: " + '\r' + bookingNr + "Rooms: " + room+ '\r' + " startDate: " +  startDate.toString() + '\r' + " endDate: " + endDate.toString();

  }



}
