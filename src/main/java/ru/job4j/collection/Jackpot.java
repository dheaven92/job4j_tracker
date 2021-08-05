package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class Jackpot {

    public static boolean checkYourWin(String[] combination) {
        HashSet<String> set = new HashSet<>(List.of(combination));
        return set.size() == 1;
    }
}
