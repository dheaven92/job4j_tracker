package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pangram {

    public static boolean checkString(String s) {
        HashSet<String> alphabet = new HashSet<>(Set.of(
                "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z"
        ));
        String[] letters = s
                .replaceAll(" ", "")
                .toLowerCase()
                .split("");
        HashSet<String> uniqueLetters = new HashSet<>(Arrays.asList(letters));
        for (String letter : alphabet) {
            if (!uniqueLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
