package ru.job4j.tracker;

import java.util.List;

public class FindByKea implements UserAction {

    private final Output out;

    public FindByKea(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Name not found");
        }
        return true;
    }
}
