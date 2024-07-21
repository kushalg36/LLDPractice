package mediator;

import bider.Colleague;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{
    List<Colleague> colleagues = new ArrayList<>();
    @Override
    public void addBider(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void placeBid(Colleague colleague, int bidAmount) {

        for(Colleague colleague1 : colleagues) {
            if(!colleague1.getName().equals(colleague.getName())) {
                colleague.receiveBidNotification(bidAmount);
            }
        }
    }
}
