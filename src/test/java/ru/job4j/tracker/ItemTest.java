package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void sortByNameIncreasing() {
        List<Item> actualItems = new ArrayList<>();
        actualItems.add(new Item("Go shopping"));
        actualItems.add(new Item("Ask questions"));
        Collections.sort(actualItems);
        List<Item> expectedItems = List.of(
                new Item("Ask questions"),
                new Item("Go shopping")
        );
        assertEquals(expectedItems, actualItems);
    }

    @Test
    public void sortByNameDecreasing() {
        List<Item> actualItems = new ArrayList<>();
        actualItems.add(new Item("Ask questions"));
        actualItems.add(new Item("Go shopping"));
        Collections.sort(actualItems, new ItemSortByNameDecreasingComparator());
        List<Item> expectedItems = List.of(
                new Item("Go shopping"),
                new Item("Ask questions")
        );
        assertEquals(expectedItems, actualItems);
    }
}