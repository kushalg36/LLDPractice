package bider;

import mediator.AuctionMediator;

public class Bider implements Colleague{
    String name;
    AuctionMediator auctionMediator;

    public Bider(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBider(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        auctionMediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBidNotification(int bidAmount) {
        System.out.println("Bidder: " + name + " got the notification that someone has put bid for: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
