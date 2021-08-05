package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PangramTest {

    @Test
    public void checkStringWhenPangram() {
        String str = "Jackdaws love my big sphinx of quartz";
        boolean b = Pangram.checkString(str);
        assertThat(b, is(true));
    }

    @Test
    public void checkStringWhenNotPangram() {
        String str = "Jackdaws love my sphinx";
        boolean b = Pangram.checkString(str);
        assertThat(b, is(false));
    }
}