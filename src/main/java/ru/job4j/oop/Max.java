package ru.job4j.oop;

public class Max {

    public static int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public static int getMax(int a, int b, int c) {
        return getMax(a, getMax(b, c));
    }

    public static int getMax(int a, int b, int c, int d) {
        return getMax(getMax(a, b), getMax(c, d));
    }
}
