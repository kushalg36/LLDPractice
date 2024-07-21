import bridge.FishBreathe;
import bridge.LivingThings;
import bridge.Tree;
import bridge.TreeBreathe;

public class Main {
    public static void main(String[] args) {
        LivingThings tree = new Tree(new TreeBreathe());
        LivingThings fish = new Tree(new FishBreathe());

        tree.breatheProcess();
        fish.breatheProcess();
    }
}