package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] dep1 = o1.split("/", 2);
        String[] dep2 = o2.split("/", 2);
        int rsl = dep2[0].compareTo(dep1[0]);
        if (rsl == 0) {
            rsl = Integer.compare(dep1.length, dep2.length);
            if (rsl == 0) {
                rsl = dep1[1].compareTo(dep2[1]);
            }
        }
        return rsl;
    }
}