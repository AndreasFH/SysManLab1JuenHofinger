package writeside.domain;

public class Room {

    private String roomNr;
    private int roomSize;

    public Room(String roomNr, int roomSize) {
        this.roomNr = roomNr;
        this.roomSize = roomSize;
    }

    public String getRoomNr() {
        return roomNr;
    }

    public int getRoomSize() {
        return roomSize;
    }

    @Override
    public String toString() {
        return "RoomNr: " + roomNr + ", RoomSize: " + roomSize + ", ";
    }
}
