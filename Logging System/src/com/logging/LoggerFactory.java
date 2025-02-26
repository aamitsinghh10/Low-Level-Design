package com.logging;

public class LoggerFactory {
    public static Logger createLogger() {
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.DEBUG); // Configurable log level

        // Creating Handlers
        ConsoleHandler consoleHandler = new ConsoleHandler();
        FileHandler fileHandler = new FileHandler();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        ExternalLogHandler externalHandler = new ExternalLogHandler();

        // Setting up Chain of Responsibility
        consoleHandler.setNext(fileHandler);
        fileHandler.setNext(databaseHandler);
        databaseHandler.setNext(externalHandler);

        // Adding Handlers to Logger
        logger.addHandler(consoleHandler);

        return logger;
    }
}

