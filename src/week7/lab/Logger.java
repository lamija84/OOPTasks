package week7.lab;

public interface Logger {
    void logMessage(String message);
}
 record RecordLogger(String name) implements Logger
{
    @Override
    public void logMessage(String message) {
        System.out.println("Record Logger [" + name + "]: " + message);
    }
}
class ClassLogger implements Logger {
    private String name;

    public ClassLogger(String name) {
        this.name = name;
    }

    @Override
    public void logMessage(String message) {
        System.out.println("ClassLogger [" + this.name + "]: " + message);
    }
}
   /* public class LoggingSystem {
        public static void main(String[] args) {
            // Instantiate RecordLogger and log messages using lambda function
            // Instantiate ClassLogger and log messages using lambda function
            Logger recordLogger = new RecordLogger("RecordLogger");
            recordLogger.logMessage(() -> "Logging with lambda function in a record");
            Logger classLogger = new ClassLogger("ClassLogger");
            classLogger.logMessage(() -> "Logging with lambda function in a class");
        }
    }

}

    */

