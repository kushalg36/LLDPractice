//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogProcessor.ERROR, "Error log");
        logProcessor.log(LogProcessor.DEBUG, "Debug log");
        logProcessor.log(LogProcessor.INFO, "Info log");
        logProcessor.log(LogProcessor.WARN, "Info log");
    }
}