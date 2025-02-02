package ru.job4j.tracker.input;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("one", "1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("2")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenMultipleValidInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("2", "2147483647", "0")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected1, is(2));
        assertThat(selected2, is(2147483647));
        assertThat(selected3, is(0));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("-1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}