import java.util.List;
import java.util.Optional;

public class DefaultParkingStrategy implements ParkingStrategy {
    @Override
    public Optional<ParkingSpot> findParkingSpot(List<ParkingFloor> floors, ParkingSpot.Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }
    
}
