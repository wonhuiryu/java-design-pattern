package behavioralPattern.chainOfResponsibilityPattern;

public class ChainOfResponsibilityClient {

    public static Logger doChaining(){
        Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);//levels:1

        Logger errorLogger = new ErrorBasedLogger(Logger.ERRORINFO);//levels:2
        consoleLogger.setNextLevelLogger(errorLogger);

        Logger debugLogger = new DebugBaseLogger(Logger.DEBUGINFO);//levels:3
        debugLogger.setNextLevelLogger(debugLogger);

        return consoleLogger;
    }


}
