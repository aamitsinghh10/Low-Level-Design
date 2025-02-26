package com.logging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class LogHandler {
    protected LogHandler next;
    protected static final ExecutorService executor = Executors.newFixedThreadPool(3);
    //Async Logging
    public void setNext(LogHandler nextHandler) {
        this.next = nextHandler;
    }
    public void handle(LogLevel level, String source, String message) {
        executor.submit(() -> processLog(level, source, message)); // Async Execution
        if (next != null) {
            next.handle(level, source, message);
        }
    }
    protected abstract void processLog(LogLevel level, String source, String message);
}

