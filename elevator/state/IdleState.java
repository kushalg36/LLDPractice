package elevator.state;

import elevator.Elevator;
import elevator.enums.Direction;
import elevator.model.Request;

public class IdleState implements ElevatorState {
    @Override
    public Direction getDirection() {
        return Direction.IDLE; // Idle state has no direction
    }

    @Override
    public void move(Elevator elevator) {
        // No movement in idle state
        if(!elevator.getUpRequests().isEmpty()) {
            elevator.setState(new MovingUpState());
        } else if(!elevator.getDownRequests().isEmpty()) {
            elevator.setState(new MovingDownState());
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        // Handle adding a request when the elevator is idle
        if (request.getDirection() == Direction.UP) {
            elevator.getUpRequests().add(request.getFloor());
            elevator.setState(new MovingUpState());
        } else if (request.getDirection() == Direction.DOWN) {
            elevator.getDownRequests().add(request.getFloor());
            elevator.setState(new MovingDownState());
        }
    }
    
}
