package chainResponsilibiltyDesignPattern;

public class Main {

    public static void main(String args[]) {
        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logObject.log(LogProcessor.ERROR, "OOPS! Exception");
        logObject.log(LogProcessor.DEBUG, "Debug this section");
        logObject.log(LogProcessor.INFO, "Giving out info");
    }

}
