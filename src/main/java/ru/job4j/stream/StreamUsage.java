package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, -4, 8, 21, 17, -32, 0));

        List<Integer> filtered = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }
}
