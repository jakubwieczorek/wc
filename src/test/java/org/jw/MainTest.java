package org.jw;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void given_pathsToInputAndOutputFile_when_programFinishes_then_outputFileContainsTheSameContentAsExpectedFile() throws IOException {
        // Given
        String inputFile = "build/resources/test/org/jw/service/test_file.txt";
        String outputFile = "build/resources/test/org/jw/service/output_file.csv";
        String expectedFile = "build/resources/test/org/jw/service/expected.csv";

        // When
        Main.main(new String[]{inputFile, outputFile});

        // Then
        List<String> expectedLines = Files.readAllLines(Path.of(expectedFile));
        List<String> outputLines = Files.readAllLines(Path.of(outputFile));

        assertThat(outputLines).containsExactlyElementsOf(expectedLines);
    }
}
