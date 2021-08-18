package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        ru.job4j.search.PhoneDictionary phones = new ru.job4j.search.PhoneDictionary();
        phones.add(
                new ru.job4j.search.Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new ru.job4j.search.Person("Alexei", "Vorontsov", "123348", "Moscow")
        );
        ArrayList<ru.job4j.search.Person> persons = phones.find("348");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
        assertThat(persons.get(1).getSurname(), is("Vorontsov"));
    }

    @Test
    public void whenNothing() {
        ru.job4j.search.PhoneDictionary phones = new ru.job4j.search.PhoneDictionary();
        phones.add(
                new ru.job4j.search.Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<ru.job4j.search.Person> persons = phones.find("Alexei");
        assertTrue(persons.isEmpty());
    }
}