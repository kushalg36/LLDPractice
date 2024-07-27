package visitor;

import hotelRoom.DoubleRoom;
import hotelRoom.SingleRoom;

public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Single room pricing computation");
        singleRoom.roomPrice = 1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Double room pricing computation");
        doubleRoom.roomPrice = 2000;
    }
}
