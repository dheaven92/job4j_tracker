package ru.job4j.collection;

import java.util.Set;

public class Firewall {

    public static String checkName(String s, Set<String> words) {
        String[] letters = s.toLowerCase().split(" ");
        for (String letter : letters) {
            if (words.contains(letter)) {
                return "Выберите другую статью...";
            }
        }
        return "Вы сделали правильный выбор!";
    }
}
