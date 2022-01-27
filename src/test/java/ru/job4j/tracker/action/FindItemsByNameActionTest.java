package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.action.FindItemsByNameAction;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindItemsByNameActionTest {

    @Test
    public void whenFindByNameSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindItemsByNameAction findByNameAction = new FindItemsByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Found item");
        input.askStr("Enter name: ");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item + ln));
        assertThat(tracker.findByName("Found item"), is(List.of(item)));
    }

    @Test
    public void whenFindByNameFailure() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindItemsByNameAction findByNameAction = new FindItemsByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Found itemm");
        input.askStr("Enter name: ");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(
                out.toString(),
                is("=== Find items by name ===" + ln
                        + "Заявки с именем: Found itemm не найдены." + ln)
        );
        assertThat(tracker.findByName("Found itemm"), is(Collections.emptyList()));
    }
}