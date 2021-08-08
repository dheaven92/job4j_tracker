package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {

    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Integer> mapWithCount = new HashMap<>();
        Map<String, Boolean> mapWithBoolean = new HashMap<>();
        for (String s : strings) {
            mapWithCount.computeIfPresent(s, (k, v) -> v + 1);
            mapWithCount.putIfAbsent(s, 1);
        }
        for (String key : mapWithCount.keySet()) {
            if (mapWithCount.get(key) >= 2) {
                mapWithBoolean.put(key, true);
            } else {
                mapWithBoolean.put(key, false);
            }
        }
        return mapWithBoolean;
    }
}
