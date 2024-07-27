package memento;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationStates {


    List<ConfigurationMemento> history = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento) {
        history.add(memento);
    }

    public ConfigurationMemento undo() {
        if(!history.isEmpty()) {
            ConfigurationMemento memento = history.getLast();
            history.remove(memento);
            return memento;
        }
        return null;
    }
}
