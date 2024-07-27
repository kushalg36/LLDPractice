package memento;

public class ConfigurationOriginator {
    int height;
    int weight;

    public ConfigurationOriginator(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public ConfigurationMemento createMemento() {
        return new ConfigurationMemento(this.height, this.weight);
    }

    public void restoreMemento(ConfigurationMemento configurationMemento) {
        this.height = configurationMemento.getHeight();
        this.weight = configurationMemento.getWeight();
    }
}
