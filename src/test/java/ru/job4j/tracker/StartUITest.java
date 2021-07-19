package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

//    @Test
//    public void whenCreateItem() {
//        Input input = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(),
//                new ExitAction()
//        };
//        new StartUI().init(input, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Input input = new StubInput(
//                new String[] {"2", "1", "Item name updated", "3"}
//        );
//        Tracker tracker = new Tracker();
//        Item item = new Item("Item name");
//        tracker.add(item);
//        UserAction[] actions = {
//                new CreateAction(),
//                new ShowAllAction(),
//                new ReplaceAction(),
//                new ExitAction()
//        };
//        new StartUI().init(input, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name updated"));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Input input = new StubInput(
//                new String[] {"3", "1", "4"}
//        );
//        Tracker tracker = new Tracker();
//        Item item = new Item("Item name");
//        tracker.add(item);
//        UserAction[] actions = {
//                new CreateAction(),
//                new ShowAllAction(),
//                new ReplaceAction(),
//                new DeleteAction(),
//                new ExitAction()
//        };
//        new StartUI().init(input, tracker, actions);
//        assertArrayEquals(tracker.findAll(), new String[0]);
//    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
}