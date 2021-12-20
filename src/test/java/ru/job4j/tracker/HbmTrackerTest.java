package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {

    @Test
    public void whenAddItemAndFindAllItems() {
        Store tracker = new HbmTracker();
        Item item = tracker.add(new Item("item"));
        List<Item> items = tracker.findAll();
        assertThat(items, is(List.of(item)));
        assertThat(items.get(0), is(item));
    }

    @Test
    public void whenReplaceItemAndFindItById() {
        Store tracker = new HbmTracker();
        Item item = tracker.add(new Item("item"));
        boolean replaced = tracker.replace(item.getId(), new Item("item updated"));
        Item foundItem = tracker.findById(item.getId());
        assertThat(replaced, is(Boolean.TRUE));
        assertThat(foundItem.getName(), is("item updated"));
    }

    @Test
    public void whenFindItemsByName() {
        Store tracker = new HbmTracker();
        Item item1 = tracker.add(new Item("item"));
        tracker.add(new Item("iitem"));
        Item item2 = tracker.add(new Item("item"));
        List<Item> foundItems = tracker.findByName("item");
        assertThat(foundItems, is(List.of(item1, item2)));
        assertThat(foundItems.get(0).getName(), is("item"));
        assertThat(foundItems.get(1).getName(), is("item"));
    }

    @Test
    public void whenAddItemAndDeleteIt() {
        Store tracker = new HbmTracker();
        Item item = tracker.add(new Item("item"));
        tracker.delete(item.getId());
        assertThat(tracker.findAll().size(), is(0));
    }
}