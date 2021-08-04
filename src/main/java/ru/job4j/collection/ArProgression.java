package ru.job4j.collection;

import java.util.List;

public class ArProgression {

    public static int checkData(List<Integer> data) {
        int sum = 0;
        if (data.size() >= 3) {
            sum = data.get(0);
            for (int i = 1; i < data.size() - 1; i++) {
                if (data.get(i) == (data.get(i - 1) + data.get(i + 1)) / 2) {
                    sum += data.get(i);
                } else {
                    return 0;
                }
            }
            sum += data.get(data.size() - 1);
        }
        return sum;
    }
}
