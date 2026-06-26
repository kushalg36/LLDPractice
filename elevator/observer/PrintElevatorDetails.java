package elevator.observer;

import elevator.Elevator;

public class PrintElevatorDetails implements ElevatorOberserver {
    @Override
    public void update(Elevator elevator) {
        System.out.println("Elevator Details:");
        System.out.println("  ID: " + elevator.getId());
        System.out.println("  Current Floor: " + elevator.getCurrentFloor());
        System.out.println("  Direction: " + elevator.getDirection());
    }
}
