package org.jw.service;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class WordsCounterTest {

    @Test
    void given_listOfStrings_when_countWithStream_then_mapOfStringsAndTheirNumberOfOccurrences() {
        // Given
        List<String> words = List.of("aaa", "bbb", "ccc", "aaa", "bbb", "aaaa");

        // When
        Map<String, Long> wordsStatistics = WordsCounter.countWithStream(words);

        // Then
        assertThat(wordsStatistics).containsEntry("aaa", 2L)
            .containsEntry("bbb", 2L)
            .containsEntry("ccc", 1L)
            .containsEntry("aaaa", 1L);
    }

    @Test
    void given_listOfStrings_when_countWithMap_then_mapOfStringsAndTheirNumberOfOccurrences() {
        // Given
        List<String> words = List.of("aaa", "bbb", "ccc", "aaa", "bbb", "aaaa");

        // When
        Map<String, Long> wordsStatistics = WordsCounter.countWithMap(words);

        // Then
        assertThat(wordsStatistics).containsEntry("aaa", 2L)
            .containsEntry("bbb", 2L)
            .containsEntry("ccc", 1L)
            .containsEntry("aaaa", 1L);
    }
}
