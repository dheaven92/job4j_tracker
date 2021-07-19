package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"2", "1", "Item name updated", "3"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("Item name");
        tracker.add(item);
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name updated"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"3", "1", "4"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("Item name");
        tracker.add(item);
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertArrayEquals(tracker.findAll(), new String[0]);
    }

    @Test
    public void whenShowAllItems() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"1", "2"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("Item name");
        tracker.add(item);
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertArrayEquals(tracker.findAll(), new Item[] {item});
    }

    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"5", "Item name", "6"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("Item name");
        tracker.add(item);
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindItemByIdAction(output),
                new FindItemsByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Show all Items" + System.lineSeparator() +
                        "2. Replace Item" + System.lineSeparator() +
                        "3. Delete Item" + System.lineSeparator() +
                        "4. Find Item by Id" + System.lineSeparator() +
                        "5. Find Items by Name" + System.lineSeparator() +
                        "6. Exit" + System.lineSeparator() +
                        "=== Find items by name ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Show all Items" + System.lineSeparator() +
                        "2. Replace Item" + System.lineSeparator() +
                        "3. Delete Item" + System.lineSeparator() +
                        "4. Find Item by Id" + System.lineSeparator() +
                        "5. Find Items by Name" + System.lineSeparator() +
                        "6. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemById() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"4", "1", "6"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("Item name");
        tracker.add(item);
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindItemByIdAction(output),
                new FindItemsByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Show all Items" + System.lineSeparator() +
                        "2. Replace Item" + System.lineSeparator() +
                        "3. Delete Item" + System.lineSeparator() +
                        "4. Find Item by Id" + System.lineSeparator() +
                        "5. Find Items by Name" + System.lineSeparator() +
                        "6. Exit" + System.lineSeparator() +
                        "=== Find item by id ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Show all Items" + System.lineSeparator() +
                        "2. Replace Item" + System.lineSeparator() +
                        "3. Delete Item" + System.lineSeparator() +
                        "4. Find Item by Id" + System.lineSeparator() +
                        "5. Find Items by Name" + System.lineSeparator() +
                        "6. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
}