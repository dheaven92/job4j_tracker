package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("bob@mail.com", "Bob");
        users.put("jason@mail.com", "Jason");
        for (String key : users.keySet()) {
            System.out.println(key + " = " + users.get(key));
        }
    }
}
