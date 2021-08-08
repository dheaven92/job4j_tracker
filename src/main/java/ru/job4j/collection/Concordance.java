package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {

    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> rsl = new HashMap<>();
        char[] chars = s.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character key = chars[i];
            if (rsl.containsKey(key)) {
                rsl.get(key).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                rsl.put(key, indexes);
            }
        }
        return rsl;
    }
}
