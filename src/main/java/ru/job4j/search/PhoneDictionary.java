package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> compareName = string -> string.getName().contains(key);
        Predicate<Person> compareSurName = string -> string.getSurname().contains(key);
        Predicate<Person> compareAddress = string -> string.getAddress().contains(key);
        Predicate<Person> comparePhone = string -> string.getPhone().contains(key);
        Predicate<Person> combine = compareName.or(compareSurName.or(compareAddress.or(comparePhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
