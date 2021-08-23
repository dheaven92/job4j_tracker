package ru.job4j.stream.extra;

import java.util.List;
import java.util.stream.Collectors;

public class CharsMethod {

    public static List<Character> symbols(String string) {
        return string.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }
}
