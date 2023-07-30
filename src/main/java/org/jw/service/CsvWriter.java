package org.jw.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class CsvWriter {

    public static final String COMMA_SEPARATOR = ",";
    public static final String LINE_BREAK = System.getProperty("line.separator");

    private CsvWriter() {
    }

    public static void writeWordsToCsv(Map<String, Long> words, String path) throws IOException {
        try (Writer writer = new FileWriter(path)) {
            for (Map.Entry<String, Long> wordCountEntry : words.entrySet()) {
                writer.write(wordCountEntry.getKey() + COMMA_SEPARATOR + wordCountEntry.getValue() + LINE_BREAK);
            }
        }
    }
}
