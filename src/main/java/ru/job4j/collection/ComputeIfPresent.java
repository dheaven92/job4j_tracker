package ru.job4j.collection;

import java.util.Map;

public class ComputeIfPresent {

    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer key : name.keySet()) {
            name.computeIfPresent(key, (k, v) -> v + " " + surname.get(key));
        }
        return name;
    }
}
