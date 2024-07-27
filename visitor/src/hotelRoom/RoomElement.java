package hotelRoom;

import visitor.RoomVisitor;

public interface RoomElement {
    public void accept(RoomVisitor roomVisitor);
}
