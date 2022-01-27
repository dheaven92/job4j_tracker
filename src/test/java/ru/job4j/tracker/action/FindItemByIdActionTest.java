package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.action.FindItemByIdAction;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemByIdActionTest {

    @Test
    public void whenFindByIdSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindItemByIdAction findByIdAction = new FindItemByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        input.askInt("Enter id: ");
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findById(1), is(item));
    }

    @Test
    public void whenFindByIdFailure() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindItemByIdAction findByIdAction = new FindItemByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        input.askInt("Enter id: ");
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find item by id ===" + ln + "Заявка с введенным id: 2 не найдена." + ln)
        );
        assertThat(tracker.findById(2), is(nullValue()));
    }
}