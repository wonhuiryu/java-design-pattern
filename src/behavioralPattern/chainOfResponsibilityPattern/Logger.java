package behavioralPattern.chainOfResponsibilityPattern;

public abstract class Logger {
    public static int OUTPUTINFO = 1;
    public static int ERRORINFO = 2;
    public static int DEBUGINFO = 3;

    protected int levels;
    protected Logger nextLevelLogger;//error, debug implements Logger

    public void setNextLevelLogger(Logger nextLevelLogger){//set nextLevelLogger
        this.nextLevelLogger = nextLevelLogger;
    }

    //이 객체에 담겨있는 log-levels가 매개변수로 전달된 levels와 같거나 작다면 로그를 출력하라
    //null이 아니면 로그메시지를 반복하라
    public void logMessage(int levels, String msg){
        if(this.levels <= levels){
            displayLogInfo(msg);
        }
        if(nextLevelLogger != null){//재귀함수수
           nextLevelLogger.logMessage(levels, msg);
        }
    }


    protected abstract void displayLogInfo(String msg);
}
