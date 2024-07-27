import hotelRoom.DoubleRoom;
import hotelRoom.RoomElement;
import hotelRoom.SingleRoom;
import visitor.RoomMaintenanceVisitor;
import visitor.RoomPricingVisitor;
import visitor.RoomVisitor;

public class Main {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();

        RoomVisitor pricingVisitor = new RoomPricingVisitor();
        singleRoom.accept(pricingVisitor);
        System.out.println(((SingleRoom) singleRoom).roomPrice);

        doubleRoom.accept(pricingVisitor);
        System.out.println(((DoubleRoom) doubleRoom).roomPrice);

        RoomVisitor maintenanceVisitor = new RoomMaintenanceVisitor();
        singleRoom.accept(maintenanceVisitor);
        doubleRoom.accept(maintenanceVisitor);
    }
}