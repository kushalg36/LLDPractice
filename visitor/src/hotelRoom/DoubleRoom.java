package hotelRoom;

import visitor.RoomVisitor;

public class DoubleRoom implements RoomElement {
    public int roomPrice = 0;

    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }
}
