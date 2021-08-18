package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            int tmpTotal = total;
            total = add(
                    () -> tmpTotal + num
            );
        }
        System.out.println(total);
    }
}
