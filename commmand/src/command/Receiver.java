package command;

public class Receiver {
    private boolean isOn;
    public void turnAcOn() {
        isOn = true;
        System.out.println("AC is on");
    }
    public void turnAcOff() {
        isOn = false;
        System.out.println("AC is off");
    }
}
