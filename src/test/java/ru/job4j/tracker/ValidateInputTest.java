package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0", "6", "-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("Enter menu:");
        input.askInt("Enter menu:");
        input.askInt("Enter menu:");
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}