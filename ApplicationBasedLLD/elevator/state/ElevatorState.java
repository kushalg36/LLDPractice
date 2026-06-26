package elevator.state;

import elevator.Elevator;
import elevator.enums.Direction;
import elevator.model.Request;

public interface ElevatorState {
    Direction getDirection();
    void move(Elevator elevator);
    void addRequest(Elevator elevator, Request request);
}
