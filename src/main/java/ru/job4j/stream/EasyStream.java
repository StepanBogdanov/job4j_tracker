package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        var newList = new ArrayList<Integer>();
        for (Integer integer : list) {
            newList.add(fun.apply(integer));
        }
        return new EasyStream(newList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        var newList = new ArrayList<Integer>();
        for (Integer integer : list) {
            if (fun.test(integer)) {
                newList.add(integer);
            }
        }
        return new EasyStream(newList);
    }

    public List<Integer> collect() {
        return list;
    }
}
