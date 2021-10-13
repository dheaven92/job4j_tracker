package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new StubInput(
                List.of("0", "Item name", "1")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item name");
        tracker.add(item);
        Input input = new StubInput(
                List.of("0", String.valueOf(item.getId()), "Item name updated", "1")
        );
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name updated"));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item name");
        tracker.add(item);
        Input input = new StubInput(
                List.of("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new DeleteAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertTrue(tracker.findAll().isEmpty());
    }

    @Test
    public void whenShowAllItems() {
        Output output = new StubOutput();
        Input input = new StubInput(
                List.of("0", "1")
        );
        Store tracker = new MemTracker();
        Item item = new Item("Item name");
        tracker.add(item);
        List<UserAction> actions = List.of(
                new ShowAllAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Show all Items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Show all Items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        Input input = new StubInput(
                List.of("0", "Item name", "1")
        );
        Store tracker = new MemTracker();
        Item item = new Item("Item name");
        tracker.add(item);
        List<UserAction> actions = List.of(
                new FindItemsByNameAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find Items by Name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find Items by Name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item name");
        tracker.add(item);
        Input input = new StubInput(
                List.of("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new FindItemByIdAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Find Item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Find Item by Id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(
                List.of("0")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("10", "0")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}