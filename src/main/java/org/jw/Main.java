package org.jw;

import org.jw.service.CsvWriter;
import org.jw.service.FileParser;
import org.jw.service.WordsCounter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java -jar target/words-counter-1.0-SNAPSHOT.jar <input_file_path> <output_file_path>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        List<String> words = FileParser.readWordsFromFile(inputFile);
        Map<String, Long> wordsStatistics = WordsCounter.countWithMap(words);
        CsvWriter.writeWordsToCsv(wordsStatistics, outputFile);
    }
}
