package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.job4j.oop.Max.getMax;

public class MaxTest {

    @Test
    public void getMaxFrom2and3() {
        assertEquals(3, getMax(2, 3));
    }

    @Test
    public void getMaxFrom10and3and0() {
        assertEquals(10, getMax(10, 3, 0));
    }

    @Test
    public void getMaxFrom10and3and0and15() {
        assertEquals(15, getMax(10, 3, 0, 15));
    }
}