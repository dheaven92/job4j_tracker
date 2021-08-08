package ru.job4j.collection;

import java.util.*;

public class Dictionary {

    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String s : strings) {
            String key = s.split("")[0];
            if (rsl.containsKey(key)) {
                rsl.get(key).add(s);
            } else {
                List<String> value = new ArrayList<>();
                value.add(s);
                rsl.put(key, value);
            }
        }
        return rsl;
    }
}
