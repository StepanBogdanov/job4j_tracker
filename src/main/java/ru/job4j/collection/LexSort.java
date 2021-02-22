package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split(". ");
        String[] rightArray = right.split(". ");
        return Integer.compare(Integer.valueOf(leftArray[0]), Integer.valueOf(rightArray[0]));
    }
}
