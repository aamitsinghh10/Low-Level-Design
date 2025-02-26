package com.logging;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler extends LogHandler {
    private static final String FILE_PATH = "logs.txt";

    @Override
    protected void processLog(LogLevel level, String source, String message) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(LogFormatter.format(level, source, message) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


