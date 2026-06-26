import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findParkingSpot(List<ParkingFloor> floors, ParkingSpot.Vehicle vehicle);
}
