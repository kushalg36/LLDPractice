package bridge;

public class Fish extends LivingThings{
    public Fish(Breathe breathe) {
        super(breathe);
    }

    @Override
    public void breatheProcess() {
        breathe.breathe();
    }
}
