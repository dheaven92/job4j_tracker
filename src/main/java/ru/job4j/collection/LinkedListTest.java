package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new ArrayList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Francas");
        b.add("Gloria");

        // объединить слова из связных списков Ь и а

        ListIterator<String> aIterator = a.listIterator();
        Iterator<String> bIterator = b.iterator();

        while (bIterator.hasNext()) {
            if (aIterator.hasNext()) {
                aIterator.next();
            }
            aIterator.add(bIterator.next());
        }
        System.out.println(a);

        // удалить каждое второе слово из связного списка Ь

        bIterator = b.iterator();

        while (bIterator.hasNext()) {
            bIterator.next(); // пропустить
            if (bIterator.hasNext()) {
                bIterator.next(); // пропустить след
                bIterator.remove(); // удалить данный
            }
        }

        System.out.println(b);

        // групповая операция удаления из связного списка а
        // всех слов, составляющих связный список Ь
        a.removeAll(b);

        System.out.println(a);
    }
}
