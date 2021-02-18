package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("iBlin@yandex.ru", "Ivan Blinov");
        map.put("vasya007@gmail.com", "Vasiliy Tyorkin");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "-" + value);
        }
    }
}
