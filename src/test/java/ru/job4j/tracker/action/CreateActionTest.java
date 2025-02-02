package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateActionTest {

    @Test
    public void whenCreateSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        CreateAction createAction = new CreateAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("New item");
        input.askStr("Enter name: ");
        createAction.execute(input, tracker);
        Item item = new Item("New item", 1);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Create a new Item ===" + ln + "Добавленная заявка: " + item + ln)
        );
        assertThat(tracker.findAll().get(0).getName(), is("New item"));
    }
}