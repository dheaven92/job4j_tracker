package ru.job4j.tracker.store;

public interface Observer<T> {

    void receive(T obj);
}
