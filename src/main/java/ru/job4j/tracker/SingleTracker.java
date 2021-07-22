package ru.job4j.tracker;

public final class SingleTracker {

    private static Tracker tracker;

    private SingleTracker() {
    }

    public static Tracker getTracker() {
        if (tracker == null) {
            return new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
