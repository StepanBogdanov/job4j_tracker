package ru.job4j.tracker;

public class FindById implements UserAction {

    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find an Item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item  != null) {
            out.println(item);
        } else {
            out.println("Item not found");
        }
        return true;
    }
}
