package bridge;

public abstract class LivingThings {

    Breathe breathe;
    public LivingThings(Breathe breathe) {
        this.breathe = breathe;
    }

    abstract public void breatheProcess();
}
