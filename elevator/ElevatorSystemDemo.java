package elevator;

import elevator.enums.Direction;

public class ElevatorSystemDemo {
    public static void main(String[] args) {
        // Setp 1: Create an instance of ElevatorSystem with the desired number of elevators
        int numberOfElevators = 3;
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance(numberOfElevators);
        // Step 2: start the elevator system
        elevatorSystem.start();
        System.out.println("Elevator system started with " + numberOfElevators + " elevators.");

        // ---- Elevator Simulation Demo ----
        // Step 3: Simulate elevator requests
        try {
            elevatorSystem.requestElevator(5, Direction.UP); // Request an elevator from floor 5
            Thread.sleep(2000); // Wait for 2 seconds

            elevatorSystem.submitRequest(1, 7); // Request to go to floor 7 from elevator 1

            elevatorSystem.requestElevator(2, Direction.DOWN); // Request an elevator from floor 2
            Thread.sleep(2000); // Wait for 2 seconds

            elevatorSystem.submitRequest(2, 0); // Request to go to floor 0 from elevator 2

            System.out.println("Elevator simulation completed.");
            Thread.sleep(1000);
            elevatorSystem.shutdown();
            System.out.println("Elevator system shutdown.");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 4: Shutdown the elevator system
            elevatorSystem.shutdown();
            System.out.println("Elevator system shutdown.");
        }

    }
}
