package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void sortByNameIncreasing() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Go shopping"));
        items.add(new Item("Ask questions"));
        Collections.sort(items);
        assertEquals(items.get(0), new Item("Ask questions"));
    }

    @Test
    public void sortByNameDecreasing() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ask questions"));
        items.add(new Item("Go shopping"));
        Collections.sort(items, new ItemSortByNameDecreasingComparator());
        assertEquals(items.get(0), new Item("Go shopping"));
    }
}