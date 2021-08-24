package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> isNameContaining = person -> person.getName().contains(key);
        Predicate<Person> isSurnameContaining = person -> person.getSurname().contains(key);
        Predicate<Person> isPhoneContaining = person -> person.getPhone().contains(key);
        Predicate<Person> isAddressContaining = person -> person.getAddress().contains(key);
        var combine = isNameContaining
                .or(isSurnameContaining)
                .or(isPhoneContaining)
                .or(isAddressContaining);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
