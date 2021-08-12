package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.job.*;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompareAscByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscByPriority() {
        Comparator<Job> comparator = new JobAscPriority();
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareDescBySameNameAndAscPriority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobAscPriority());
        int rsl = comparator.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescByNameAndDescPriority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareDescBySameNameAndDescPriority() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, is(0));
    }
}