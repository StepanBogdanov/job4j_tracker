package ru.job4j.tracker;

public class ReplaceAction implements UserAction{

    @Override
    public String name() {
        return "=== Replace an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new item's name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item has been replaced");
        } else {
            System.out.println("Id not found");
        }
        return true;
    }
}
