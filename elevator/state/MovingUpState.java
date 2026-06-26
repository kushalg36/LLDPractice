package elevator.state;

import elevator.Elevator;
import elevator.enums.Direction;
import elevator.enums.RequestType;
import elevator.model.Request;

public class MovingUpState implements ElevatorState {

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }

    @Override
    public void move(Elevator elevator) {
        if(elevator.getUpRequests().isEmpty()) {
            // If there are no more up requests, transition to IdleState or MovingDownState
            if (!elevator.getDownRequests().isEmpty()) {
                elevator.setState(new MovingDownState());
            } else {
                elevator.setState(new IdleState());
            }
            return;
        }
        // Move the elevator up by one floor
        elevator.setCurrentFloor(elevator.getCurrentFloor().get() + 1);
        System.out.println("Elevator " + elevator.getId() + " moving up to floor " + elevator.getCurrentFloor());

        // Check if there are any requests for the current floor
        if (elevator.getUpRequests().contains(elevator.getCurrentFloor().get())) {
            // Stop at the current floor and remove the request
            System.out.println("Elevator " + elevator.getId() + " stopping at floor " + elevator.getCurrentFloor());
            elevator.getUpRequests().remove(elevator.getCurrentFloor().get());
        }

        // If there are no more up requests, transition to IdleState or MovingDownState
        if (elevator.getUpRequests().isEmpty()) {
            if (!elevator.getDownRequests().isEmpty()) {
                elevator.setState(new MovingDownState());
            } else {
                elevator.setState(new IdleState());
            }
        }
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        // Add the request to the upRequests set if it's an upward request
        if(request.getRequestType() == RequestType.EXTERNAL) {
            if (request.getDirection() == Direction.UP) {
                elevator.getUpRequests().add(request.getFloor());
            } else if (request.getDirection() == Direction.DOWN) {
                // If it's a downward request, add it to the downRequests set
                elevator.getDownRequests().add(request.getFloor());
            }
        } else if(request.getRequestType() == RequestType.INTERNAL) {
            if (request.getFloor() > elevator.getCurrentFloor().get()) {
                elevator.getUpRequests().add(request.getFloor());
            } else if (request.getFloor() < elevator.getCurrentFloor().get()) {
                // If it's a downward request, add it to the downRequests set
                elevator.getDownRequests().add(request.getFloor());
            }
        }
    }
    
}
