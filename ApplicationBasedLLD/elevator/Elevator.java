package elevator;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import elevator.enums.Direction;
import elevator.model.Request;
import elevator.observer.ElevatorOberserver;
import elevator.state.ElevatorState;
import elevator.state.IdleState;

public class Elevator implements Runnable {
    private int id;
    private AtomicInteger currentFloor;
    private ElevatorState state; // Current state of the elevator (e.g., IDLE, MOVING_UP, MOVING_DOWN)
    private boolean isRunning;
    private TreeSet<Integer> upRequests;
    private TreeSet<Integer> downRequests;
    private final List<ElevatorOberserver> observers = new ArrayList<>();

    public Elevator(int id) {
        // Constructor implementation
        this.id = id;
        this.currentFloor = new AtomicInteger(1); // Assuming ground floor is 1
        this.state = new IdleState(); // Initial state is IDLE
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>(Collections.reverseOrder());
        isRunning = true;
    }

    public void move() {
        state.move(this);
    }

    public void addRequest(Request request) {
        System.out.println("Elevator " + id + " received request to go to floor " + request.getFloor() + " in direction " + request.getDirection());
        state.addRequest(this, request);
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyObservers(); // Notify observers on direction change
    }

    public TreeSet<Integer> getUpRequests() {
        return upRequests;
    }
    public TreeSet<Integer> getDownRequests() {
        return downRequests;
    }
    public AtomicInteger getCurrentFloor() {
        return currentFloor;
    }
    public int getId() {
        return id;
    }
    public Direction getDirection() {
        return state.getDirection();
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor.set(floor);
        notifyObservers(); // Notify observers on direction change
    }

    public void addObserver(ElevatorOberserver observer) {
        observers.add(observer);
        observer.update(this);
    }

    public void notifyObservers() {
        for (ElevatorOberserver observer : observers) {
            observer.update(this);
        }
    }

    public void run() {
        // Elevator logic to process requests and move between floors
        while(isRunning) {
            move();
            try {
                Thread.sleep(1000); // Simulate time taken to move between floors
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        isRunning = false;
    }
    
}
