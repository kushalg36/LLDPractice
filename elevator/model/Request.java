package elevator.model;
import elevator.enums.*;

public class Request {
    private int floor;
    private Direction direction;
    private RequestType requestType;

    public Request(int floor, Direction direction, RequestType requestType) {
        this.floor = floor;
        this.direction = direction;
        this.requestType = requestType;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getFloor() {
        return floor;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
