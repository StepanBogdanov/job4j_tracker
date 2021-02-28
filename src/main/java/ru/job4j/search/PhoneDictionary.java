package ru.job4j.search;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.function.Predicate;


public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                boolean rsl = false;
                Field[] fields = person.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String value = null;
                    try {
                        value = (String) field.get(person);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (value.equals(key)) {
                        rsl = true;
                        break;
                    }
                }
                return rsl;
            }
        };
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
