package org.jw.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileParserTest {

    @Test
    void given_testFile_when_readWordsFromFile_then_listContainParsedAndFormattedWords() throws IOException {
        // Given
        String path = "src/test/resources/org/jw/service/test_file.txt";

        // When
        List<String> words = FileParser.readWordsFromFile(path);

        // Then
        assertThat(words).doesNotContain( "”", "—dennis", "“tell", "scenes…")
            .hasSize(56);
    }
}
