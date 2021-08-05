package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class UniqueName {

    public static int collectUniqueName(List<User> users) {
        HashSet<User> uniqueUsers = new HashSet<>();
        for (User user : users) {
            uniqueUsers.add(user);
        }
        return uniqueUsers.size();
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
