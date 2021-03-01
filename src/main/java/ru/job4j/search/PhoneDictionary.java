package ru.job4j.search;


import java.util.ArrayList;
import java.util.function.Predicate;


public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> checkName = p -> p.getName().equals(key);
        Predicate<Person> checkSurname = p -> p.getSurname().equals(key);
        Predicate<Person> checkPhone = p -> p.getPhone().equals(key);
        Predicate<Person> checkAddress = p -> p.getAddress().equals(key);
        Predicate<Person> combine = checkName.or(checkSurname.or(checkPhone.or(checkAddress)));
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
