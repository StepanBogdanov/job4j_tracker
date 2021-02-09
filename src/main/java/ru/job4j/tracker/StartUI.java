package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] all = tracker.findAll();
                for (Item item : all) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter new item's name: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item has been replaced");
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 3) {
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Item has been deleted");
                } else {
                    System.out.println("Id not found");
                }
            } else if (select == 4) {
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if (item  != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Item not found");
                }
            } else if (select == 5) {
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Name not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find Item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
