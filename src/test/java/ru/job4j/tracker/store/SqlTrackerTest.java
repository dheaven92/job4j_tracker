package ru.job4j.tracker.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenUpdateItem() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item savedItem = tracker.add(item);
        item.setName("item updated");
        tracker.replace(savedItem.getId(), item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new SqlTracker(connection);
        Item savedItem = tracker.add(new Item("item"));
        assertTrue(tracker.delete(savedItem.getId()));
        assertFalse(tracker.delete(2));
    }

    @Test
    public void whenFindAllItems() {
        Store tracker = new SqlTracker(connection);
        List<Item> items = List.of(new Item("item 1"), new Item("item 2"));
        items.forEach(tracker::add);
        List<Item> savedItems = tracker.findAll();
        assertThat(savedItems, is(items));
        assertThat(savedItems.get(0), is(items.get(0)));
    }

    @Test
    public void whenFindByName() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item savedItem = tracker.add(item);
        assertThat(tracker.findByName(savedItem.getName()), is(List.of(item)));
    }

    @Test
    public void whenFindById() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item savedItem = tracker.add(item);
        assertThat(tracker.findById(savedItem.getId()), is(item));
    }
}