package elevator;

import java.util.List;
import java.util.Optional;

import elevator.model.Request;
import elevator.enums.*;

public class ElevatorSelectionStrategy {
    public Optional<Elevator> selectElevator(List<Elevator> elevators, Request request) {
        // select the list of elevators which are either idle or moving in the same direction as the request
        // return the nearest most suitable elevator based on the current floor and the requested floor
        Elevator selectedElevator = null;
        int minimumDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevators) {
            if(isSuitableElevator(elevator, request)) {
                minimumDistance = Math.min(minimumDistance, Math.abs(elevator.getCurrentFloor().get() - request.getFloor()));
                if(minimumDistance == Math.abs(elevator.getCurrentFloor().get() - request.getFloor())) {
                    selectedElevator = elevator;
                }
            }
        }
        return Optional.ofNullable(selectedElevator);
    }

    private boolean isSuitableElevator(Elevator elevator, Request request) {
        // Check if the elevator is idle or moving in the same direction as the request
        if(elevator.getDirection() == Direction.IDLE) {
            return true; // Elevator is idle
        } else if(elevator.getDirection() == request.getDirection()) {
            // Elevator is moving in the same direction as the request
            if(request.getDirection() == Direction.UP && elevator.getCurrentFloor().get() <= request.getFloor()) {
                return true; // Elevator is moving up and is below or at the requested floor
            } else if(request.getDirection() == Direction.DOWN && elevator.getCurrentFloor().get() >= request.getFloor()) {
                return true; // Elevator is moving down and is above or at the requested floor
            }
        }
        return false;
    }
}