import bider.Bider;
import bider.Colleague;
import mediator.Auction;
import mediator.AuctionMediator;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();

        Colleague colleague1 = new Bider("Kushal", auctionMediator);
        Colleague colleague2 = new Bider("Anukool", auctionMediator);
        Colleague colleague3 = new Bider("Yash", auctionMediator);

        colleague1.placeBid(1000);
        colleague2.placeBid(2000);
        colleague3.placeBid(3000);
    }
}