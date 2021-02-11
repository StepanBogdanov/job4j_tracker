package ru.job4j.tracker;

public class FindByKea implements UserAction{

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
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Name not found");
        }
        return true;
    }
}
