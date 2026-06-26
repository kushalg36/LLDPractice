import java.util.*;

public class Ticket {
    public String id;
    public ParkingSpot.Vehicle vehicle;
    public ParkingSpot parkingSpot;
    public Date entryTime;

    public Ticket(ParkingSpot.Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = new Date();
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}