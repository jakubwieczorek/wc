package org.jw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class WordsCounter {
    private WordsCounter() {
    }

    public static Map<String, Long> countWithStream(List<String> words) {
        return words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
    public static Map<String, Long> countWithMap(List<String> words) {
        Map<String, Long> map = new HashMap<>();

        words.forEach(word -> map.merge(word, 1L, Long::sum));

        return map;
    }
}
