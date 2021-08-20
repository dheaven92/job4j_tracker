package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1, -5, 34, 0, -18, 999));
        List<Integer> positiveInts = ints.stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
        for (Integer positiveInt : positiveInts) {
            System.out.println(positiveInt);
        }
    }
}
