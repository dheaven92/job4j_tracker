package ru.job4j.tracker;

import org.junit.Test;

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