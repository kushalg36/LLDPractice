package elevator.state;

import elevator.Elevator;
import elevator.enums.Direction;
import elevator.enums.RequestType;
import elevator.model.Request;

public class MovingDownState implements ElevatorState {

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public void move(Elevator elevator) {
        if(elevator.getDownRequests().isEmpty()) {
            // If there are no more down requests, transition to IdleState or MovingUpState
            if (!elevator.getUpRequests().isEmpty()) {
                elevator.setState(new MovingUpState());
            } else {
                elevator.setState(new IdleState());
            }
            return;
        }
        // Move the elevator down by one floor
        elevator.setCurrentFloor(elevator.getCurrentFloor().get() - 1);
        System.out.println("Elevator " + elevator.getId() + " moving down to floor " + elevator.getCurrentFloor()); 

        if(elevator.getDownRequests().contains(elevator.getCurrentFloor().get())) {
            // Stop at the current floor and remove the request
            System.out.println("Elevator " + elevator.getId() + " stopping at floor " + elevator.getCurrentFloor());
            elevator.getDownRequests().remove(elevator.getCurrentFloor().get());
        }

        if(elevator.getDownRequests().isEmpty()) {
            if (!elevator.getUpRequests().isEmpty()) {
                elevator.setState(new MovingUpState());
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
