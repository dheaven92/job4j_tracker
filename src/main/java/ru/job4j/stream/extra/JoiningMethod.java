package ru.job4j.stream.extra;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningMethod {

    public static String join(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(
                        System.lineSeparator(),
                        "Prefix",
                        "Suffix"
                ));
    }

    public static void main(String[] args) {
        System.out.println(join(List.of("A", "B", "C")));
    }
}