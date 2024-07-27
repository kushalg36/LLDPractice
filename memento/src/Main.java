import memento.ConfigurationMemento;
import memento.ConfigurationOriginator;
import memento.ConfigurationStates;

public class Main {
    public static void main(String[] args) {
        ConfigurationStates configurationStates = new ConfigurationStates();
        //init state of originator
        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(10, 10);

        //save data
        ConfigurationMemento snapshot1 = configurationOriginator.createMemento();

        // add it to history
        configurationStates.addMemento(snapshot1);

        configurationOriginator.setHeight(20);
        configurationOriginator.setWeight(20);

        //save data
        ConfigurationMemento snapshot2 = configurationOriginator.createMemento();
        // add it to history
        configurationStates.addMemento(snapshot2);

        configurationOriginator.setHeight(30);
        configurationOriginator.setWeight(30);

        ConfigurationMemento restoredState = configurationStates.undo();
        configurationOriginator.restoreMemento(restoredState);
        System.out.println("configuration - height: " + configurationOriginator.getHeight() + ", weight: " + configurationOriginator.getWeight());
    }
}