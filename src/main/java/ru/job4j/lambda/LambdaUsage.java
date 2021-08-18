package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> compDescByLength = (left, right) -> {
            System.out.println("compare \"" + right + "\" with \""
                    + left + "\" by length in desc order");
            return right.length() - left.length();
        };
    }
}
