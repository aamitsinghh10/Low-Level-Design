package com.logging;

public class ExternalLogHandler extends LogHandler {
    @Override
    protected void processLog(LogLevel level, String source, String message) {
        System.out.println("[External System] Sending log to ELK/Splunk: " +
                LogFormatter.format(level, source, message));
        // Here, you could send logs via an HTTP request to ELK, Splunk, etc.
    }
}

