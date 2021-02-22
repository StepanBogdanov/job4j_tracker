package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int index = 0;
        while (index < left.length() && index < right.length()) {
            rsl = Character.compare(left.charAt(index), right.charAt(index++));
            if (rsl != 0) {
                break;
            }
        }
        if (left.length() > right.length() && rsl == 0) {
            rsl = 1;
        } else if (right.length() > left.length() && rsl == 0) {
            rsl = -1;
        }
        return rsl;
    }
}
