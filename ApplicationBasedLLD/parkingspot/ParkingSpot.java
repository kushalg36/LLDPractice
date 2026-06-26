public class ParkingSpot {
    // id, isOccupied, vehicle, type
    public String id;
    public boolean isOccupied;
    public Vehicle vehicle;
    public ParkingSpotType type;

    public enum ParkingSpotType {
        COMPACT, LARGE, HANDICAPPED
    }

    public enum Vehicle {
        MOTORCYCLE, CAR, TRUCK
    }

    public ParkingSpot(String id, ParkingSpotType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (!isOccupied && canFitVehicle(vehicle)) {
            this.vehicle = vehicle;
            this.isOccupied = true;
        } else {
            throw new IllegalStateException("Parking spot is already occupied.");
        }
    }

    public synchronized void unparkVehicle() {
        if (isOccupied) {
            this.vehicle = null;
            this.isOccupied = false;
        } else {
            throw new IllegalStateException("Parking spot is already empty.");
        }
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        switch (this.type) {
            case COMPACT:
                return vehicle == Vehicle.MOTORCYCLE || vehicle == Vehicle.CAR;
            case LARGE:
                return vehicle == Vehicle.MOTORCYCLE || vehicle == Vehicle.CAR || vehicle == Vehicle.TRUCK;
            case HANDICAPPED:
                return vehicle == Vehicle.MOTORCYCLE || vehicle == Vehicle.CAR;
            default:
                return false;
        }
    }
}
