package org.jw.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileParser {
    private static final List<String> REDUNDANT_CHARACTERS = List.of("“", "”", "—", "…", "\\.",
        "\\(", "\\)", "\\,", "\\?", "!", ":", ";", "\"");

    private static final Pattern REDUNDANT_CHARACTERS_PATTERN = Pattern.compile(String.join("|", REDUNDANT_CHARACTERS));

    private FileParser() {
    }

    private static final Pattern WORDS_SEPARATORS = Pattern.compile("\\s+");

    public static List<String> readWordsFromFile(String filePath) throws IOException {

        try (Stream<String> linesStream = Files.lines(Path.of(filePath), StandardCharsets.UTF_8)) {
            return linesStream
                .flatMap(line -> Stream.of(WORDS_SEPARATORS.split(line)))
                .map(word -> REDUNDANT_CHARACTERS_PATTERN.matcher(word).replaceAll(""))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .toList();
        }
    }
}
