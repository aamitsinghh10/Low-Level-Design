package com.logging;

public class DatabaseHandler extends LogHandler {
    @Override
    protected void processLog(LogLevel level, String source, String message) {
        System.out.println("[Database] Storing log: " + LogFormatter.format(level, source, message));
    }
}

