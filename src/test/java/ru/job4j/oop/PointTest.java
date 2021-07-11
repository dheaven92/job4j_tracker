package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void when00to20then2() {
        int expected = 2;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 0);
        double out = point1.distance(point2);
        assertEquals(expected, out, 0.01);
    }

    @Test
    public void when000to001then1() {
        double expected = 1;
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(0, 0, 1);
        double out = point1.distance3d(point2);
        assertEquals(expected, out, 0.01);
    }
}