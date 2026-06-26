import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {
    int floorNumber;
    Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ConcurrentHashMap<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.put(spot.id, spot);
    }

    public synchronized ParkingSpot findAvailableSpot(ParkingSpot.Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots.values()) {
            if (!spot.isOccupied && spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null; // No available spot found
    }
}
