package ru.job4j.tracker;

import java.util.Comparator;

public class ItemSortByNameDecreasingComparator implements Comparator<Item> {

    @Override
    public int compare(Item item, Item anotherItem) {
        return anotherItem.getName().compareTo(item.getName());
    }
}
