package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {

    public static int generateAndSum(int first, int denominator, int count) {
        int sum = 0;
        List<Integer> progression = new ArrayList<>();
        progression.add(first);
        sum += first;
        for (int i = 1; i < count; i++) {
            int el = progression.get(i - 1) * denominator;
            progression.add(el);
            sum += el;
        }
        return sum;
    }
}
