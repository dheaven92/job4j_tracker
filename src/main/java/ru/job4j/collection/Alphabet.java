package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Alphabet {

    public static String reformat(String s) {
        List<String> letters = Arrays.asList(s.split(""));
        letters.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder rsl = new StringBuilder();
        for (String letter : letters) {
            rsl.append(letter);
        }
        return rsl.toString();
    }
}
