package mediator;

import bider.Colleague;

public interface AuctionMediator {
    void addBider(Colleague colleague);
    void placeBid(Colleague colleague, int bidAmount);
}
