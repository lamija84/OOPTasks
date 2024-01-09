package week13.github.lab.task1;

public class Logger {
    private static Logger instance;

    private Logger()
    {

    }

    public static Logger getInstance() {
        //synchronized (Logger.class)
        {
            if(instance == null) {

                instance = new Logger();
            }
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    public void logInfo(String message) {
        System.out.println("Info: " + message);
    }
    public void logWarning(String message) {
        System.out.println("Warning: " + message);
    }
    public void logError(String message) {
        System.out.println("Error: " + message);
    }

}
class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application started");
        logger.log("Error: Something went wrong!");

        // Log a success message
        logger.log("Operation completed successfully");
        logger.logInfo("This is an informational message.");
        logger.logWarning("Be cautious! This is a warning message.");
        logger.logError("An error occurred. Please check the logs.");
    }
}

