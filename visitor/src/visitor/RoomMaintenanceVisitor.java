package visitor;

import hotelRoom.DoubleRoom;
import hotelRoom.SingleRoom;

public class RoomMaintenanceVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("maintenance work started for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("maintenance work started for double room");
    }
}
