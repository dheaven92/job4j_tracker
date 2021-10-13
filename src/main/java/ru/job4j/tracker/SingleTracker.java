package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public final class SingleTracker {

    private static SingleTracker instance = null;

    private Store tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            return new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) throws SQLException {
        return tracker.add(item);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
