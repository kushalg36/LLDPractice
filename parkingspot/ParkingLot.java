import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    public static ParkingLot instance;
    public ParkingStrategy parkingStrategy;
    public FeeStrategy feeStrategy;
    public List<ParkingFloor> parkingFloors;
    public Map<String, Ticket> activeTickets;

    public ParkingLot() {
        this.parkingStrategy = new DefaultParkingStrategy();
        this.feeStrategy = new DefaultFeeStrategy();
        this.parkingFloors = new ArrayList<>();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public void addParkingFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void setParkingStrategy(ParkingStrategy strategy) {
        this.parkingStrategy = strategy;
    }

    public void setFeeStrategy(FeeStrategy strategy) {
        this.feeStrategy = strategy;
    }

    public Optional<Ticket> parkVehicle(ParkingSpot.Vehicle vehicle) {
        Optional<ParkingSpot> spot = parkingStrategy.findParkingSpot(parkingFloors, vehicle);
        if(spot.isPresent()) {
            ParkingSpot parkingSpot = spot.get();
            parkingSpot.parkVehicle(vehicle);
            Ticket ticket = new Ticket(vehicle, spot.get());
            activeTickets.put(ticket.getId(), ticket);
            return Optional.of(ticket);
        }
        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String ticketId) {
        if(activeTickets.containsKey(ticketId)) {
            Ticket ticket = activeTickets.get(ticketId);
            ParkingSpot spot = ticket.getParkingSpot();
            spot.unparkVehicle();
            double fee = feeStrategy.calculateFee(ticket);
            activeTickets.remove(ticketId);
            return Optional.of(fee);
        }
        return Optional.empty();
    }
}