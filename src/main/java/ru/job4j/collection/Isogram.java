package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class Isogram {

    public static boolean checkString(String s) {
        HashSet<String> letters = new HashSet<>(List.of(s.split("")));
        return letters.size() == s.length();
    }
}
