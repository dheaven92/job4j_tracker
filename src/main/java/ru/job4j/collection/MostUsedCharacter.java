package ru.job4j.collection;

import java.util.*;

public class MostUsedCharacter {

    public static char getMaxCount(String str) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] characters = str
                .replaceAll(" ", "")
                .toLowerCase()
                .toCharArray();
        for (Character character : characters) {
            map.putIfAbsent(character, 1);
            map.computeIfPresent(character, (k, v) -> v + 1);
        }
        List<Character> keys = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());
        Integer maxValue = Collections.max(values);
        int index = values.indexOf(maxValue);
        return keys.get(index);
    }
}
