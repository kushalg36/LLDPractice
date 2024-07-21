package command;

public class TurnAcOnCommand implements Command{
    private Receiver receiver;
    public TurnAcOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.turnAcOn();
    }

    @Override
    public void undo() {
        receiver.turnAcOff();
    }
}
