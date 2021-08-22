package ru.job4j.stream.extra;

import java.util.List;

public class ReductionWithTwoArguments {

    public static Integer collect(List<Integer> list) {
        return list.stream()
                .reduce(5, (el1, el2) -> el1 * el2);
    }
}
