package visitor;

import hotelRoom.DoubleRoom;
import hotelRoom.SingleRoom;

public interface RoomVisitor {
    public void visit(SingleRoom singleRoom);
    public void visit(DoubleRoom doubleRoom);
}
