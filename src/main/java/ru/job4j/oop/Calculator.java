package ru.job4j.oop;

public class Calculator {

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        double tmp = add(second, third);
        return add(first, tmp);
    }
}
