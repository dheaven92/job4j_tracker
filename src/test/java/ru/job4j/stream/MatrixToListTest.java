package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void convert() {
        Integer[][] matrix = new Integer[][] {{1, 2}, {3, 4}};
        List<Integer> expectedList = List.of(1, 2, 3, 4);
        List<Integer> actualList = MatrixToList.convert(matrix);
        assertEquals(expectedList, actualList);
    }
}