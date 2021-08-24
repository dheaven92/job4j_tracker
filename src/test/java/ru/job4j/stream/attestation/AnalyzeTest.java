package ru.job4j.stream.attestation;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AnalyzeTest {

    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                ).stream()
        );
        assertThat(average, is(100D));
    }

    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                ).stream()
        );
        assertThat(average, is(80D));
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 100)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                ).stream()
        );
        assertThat(average, is(List.of(
                new Tuple("Ivanov", 100D),
                new Tuple("Petrov", 60D)
        )));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 100)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                ).stream()
        );
//        assertThat(average, is(List.of(
//                new Tuple("Math", 80D),
//                new Tuple("Lang", 80D)
//        )));
        List<Tuple> expected = List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D)
        );
        assertTrue(expected.size() == average.size()
                && expected.containsAll(average)
                && average.containsAll(expected));
    }

    @Test
    public void whenBestPupil() {
        Tuple best = Analyze.bestStudent(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 100)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                ).stream()
        );
        assertThat(best, is(new Tuple("Ivanov", 200D)));
    }

    @Test
    public void whenBestSubject() {
        Tuple best = Analyze.bestSubject(
                List.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Lang", 40)
                        )),
                        new Pupil("Petrov", List.of(
                                new Subject("Math", 60),
                                new Subject("Lang", 60)
                        ))
                ).stream()
        );
        assertThat(best, is(new Tuple("Math", 160D)));
    }
}