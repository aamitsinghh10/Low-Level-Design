package com.logging;

public class ConsoleHandler extends LogHandler {
    @Override
    protected void processLog(LogLevel level, String source, String message) {
        System.out.println(LogFormatter.format(level, source, message));
    }
}

