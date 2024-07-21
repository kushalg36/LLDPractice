package bridge;

public class Tree extends LivingThings {

    public Tree(Breathe breathe) {
        super(breathe);
    }

    @Override
    public void breatheProcess() {
        breathe.breathe();
    }
}
