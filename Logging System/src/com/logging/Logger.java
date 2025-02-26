package com.logging;

import java.util.ArrayList;
import java.util.List;
public class Logger {
    private static Logger instance;  private LogLevel logLevel;
    private List<LogHandler> handlers = new ArrayList<>();
    private Logger() { }
    public static synchronized Logger getInstance() {
        if (instance == null) { instance = new Logger(); }
        return instance;
    }
    public void setLogLevel(LogLevel logLevel) { this.logLevel = logLevel; }
    public void addHandler(LogHandler handler) { handlers.add(handler); }
    public void log(LogLevel level, String source, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            for (LogHandler handler : handlers) {
                handler.handle(level, source, message);
            }
        }
    }
}
