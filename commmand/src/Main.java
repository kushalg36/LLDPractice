import command.Invoker;
import command.Receiver;
import command.TurnAcOnCommand;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();

        invoker.setCommand(new TurnAcOnCommand(receiver));
        invoker.pressButton();
        invoker.undoOperation();
    }
}