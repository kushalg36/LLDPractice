package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameSubject {
    public List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Game game) {
        for (GameObserver observer : observers) {
            observer.update(game);
        }
    }
}
