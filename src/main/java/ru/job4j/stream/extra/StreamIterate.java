package ru.job4j.stream.extra;

import java.util.stream.Stream;

public class StreamIterate {

    public static void showArray(Integer[] data) {
        Stream.iterate(0, i -> i < data.length, i -> i + 2)
                .forEach(i -> System.out.println(data[i]));
    }

    public static void main(String[] args) {
        showArray(new Integer[] {1, 2, 3, 4});
    }
}
