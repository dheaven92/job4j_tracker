package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapason {

    public static List<Double> diapason(int a, int b, Function<Double, Double> function) {
        List<Double> rsl = new ArrayList<>();
        for (double i = a; i < b; i++) {
            rsl.add(function.apply(i));
        }
        return rsl;
    }
}
