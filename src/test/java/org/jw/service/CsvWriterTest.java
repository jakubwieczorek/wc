package org.jw.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CsvWriterTest {
    private static final String ACTUAL_FILE_PATH = "build/resources/test/org/jw/service/actual.csv";

    @Test
    void given_mapOfWordsAndTheirOccurrences_when_writeWordsToCsv_then_actualAndExpectedFilesContainsTheSameData() throws IOException {
        // Given
        Map<String, Long> words = Map.of("ccc", 1L, "bbb", 2L, "aaa", 2L, "aaaa", 1L);

        // When
        CsvWriter.writeWordsToCsv(words, ACTUAL_FILE_PATH);

        // Then
        Files.readAllLines(Path.of(ACTUAL_FILE_PATH)).forEach(line ->
            assertThat(line).containsAnyOf("aaa,2", "bbb,2", "ccc,1", "aaaa,1"));
    }
}
