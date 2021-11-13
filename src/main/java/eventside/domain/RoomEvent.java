package eventside.domain;

public class RoomEvent {

  private String roomNr;
  private int roomSize;

  public String getRoomNr() {
    return roomNr;
  }

  public void setRoomNr(String roomNr) {
    this.roomNr = roomNr;
  }

  public int getRoomSize() {
    return roomSize;
  }

  public void setRoomSize(int roomSize) {
    this.roomSize = roomSize;
  }

  @Override
  public String toString() {
    return "RoomNr: " + roomNr + '\r' + "RoomSize: " + roomSize;
  }
}
