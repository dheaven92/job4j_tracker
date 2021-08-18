package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] deps1 = o1.split("/");
        String[] deps2 = o2.split("/");
        int firstElementsComp = deps2[0].compareTo(deps1[0]);
        return firstElementsComp != 0 ? firstElementsComp : o1.compareTo(o2);
    }
}
