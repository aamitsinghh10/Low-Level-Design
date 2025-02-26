package com.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFormatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String format(LogLevel level, String source, String message) {
        return String.format("[%s] [%s] [%s]: %s",
                LocalDateTime.now().format(formatter), level, source, message);
    }
}

