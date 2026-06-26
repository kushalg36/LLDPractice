package elevator;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import elevator.enums.Direction;
import elevator.enums.RequestType;
import elevator.model.Request;
import elevator.observer.ElevatorOberserver;
import elevator.observer.PrintElevatorDetails;

public class ElevatorSystem {
    private static ElevatorSystem instance;
    private Map<Integer, Elevator> elevators;
    private ExecutorService executorService;
    private ElevatorSelectionStrategy selectionStrategy;

    private ElevatorSystem(int numberOfElevators) {
        // Initialize the elevator system with the specified number of elevators
        List<Elevator> elevatorList = new ArrayList<>();
        elevators = new HashMap<>();
        executorService = Executors.newFixedThreadPool(numberOfElevators);
        ElevatorOberserver elevatorObserver = new PrintElevatorDetails();
        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator(i);
            elevatorList.add(elevator);
            elevator.addObserver(elevatorObserver);
            elevators.put(i, elevator);
        }
        selectionStrategy = new ElevatorSelectionStrategy();
    }

    public static ElevatorSystem getInstance(int numberOfElevators) {
        // Implementation to return an instance of ElevatorSystem
        if(instance == null) {
            instance = new ElevatorSystem(numberOfElevators);
        }
        return instance;
    }

    public void start() {
        // Start the elevator system
        executorService.submit(() -> {
            // Elevator system logic to handle requests and manage elevators
            for(Elevator elevator : elevators.values()) {
                // Start each elevator in a separate thread
                executorService.submit(elevator);
            }
        });
    }

    public void requestElevator(int floor, Direction direction) {
        // Handle elevator request from a specific floor in a given direction
        Request request = new Request(floor, direction, RequestType.EXTERNAL);
        // Use the selection strategy to choose an elevator for the request
        Optional<Elevator> selectedElevator = selectionStrategy.selectElevator(new ArrayList<>(elevators.values()), request);
        // Submit the request to the selected elevator, or handle absence
        selectedElevator.ifPresentOrElse(elevator -> {
            // Submit the request to the selected elevator
            elevator.addRequest(request);
        }, () -> {
            // Handle the case where no elevator is available for the request
            System.err.println("No available elevator for the request at floor " + floor + " in direction " + direction);
        });
    }

    public void submitRequest(int elevatorId, int destinationFloor) {
        // Handle request to go to a specific floor from a specific elevator
        Request request = new Request(destinationFloor, Direction.IDLE, RequestType.INTERNAL);
        Elevator elevator = elevators.get(elevatorId);
        if (elevator != null) {
            elevator.addRequest(request);
        } else {
            System.err.println("Elevator with ID " + elevatorId + " not found.");   
        }
    }

    public void shutdown() {
        // Shutdown the elevator system
        for (Elevator elevator : elevators.values()) {
            elevator.shutdown();
        }
        executorService.shutdown();
    }
}
