package command;

import java.util.Stack;

public class Invoker {
    Stack<Command> acCommandHistory = new Stack<>();
    Command command;
    public Invoker(){}

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        acCommandHistory.add(command);
    }


    public void undoOperation() {
        if(!acCommandHistory.isEmpty()) {
            Command command1 = acCommandHistory.pop();
            command1.undo();
        }
    }
}
