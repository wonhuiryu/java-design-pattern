package behavioralPattern.chainOfResponsibilityPattern;

public class DebugBaseLogger extends Logger {

    public DebugBaseLogger(int levels) {
        this.levels=levels;
    }
    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("DEBUG LOGGER INFO: "+msg);
    }
}
