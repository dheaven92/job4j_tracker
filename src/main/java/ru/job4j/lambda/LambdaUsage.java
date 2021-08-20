package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> compDescByLength = (left, right) -> {
            System.out.println("compare \"" + right + "\" with \""
                    + left + "\" by length in desc order");
            return Integer.compare(right.length(), left.length());
        };
        List<String> list = new ArrayList<>(List.of("abc", "abcde", "abcd"));
        list.sort(compDescByLength);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
