package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MergeMultipleMapsTest {

    @Test
    public void merge() {
        Map<String, Integer> map1 = Map.of(
                "a", 1,
                "b", 10
        );
        Map<String, Integer> map2 = Map.of(
                "a", 2,
                "b", 4
        );
        Map<String, Integer> actual = MergeMultipleMaps.merge(List.of(map1, map2));
        Map<String, Integer> expected = Map.of(
                "a", 3,
                "b", 14
        );
        assertEquals(expected, actual);
    }
}