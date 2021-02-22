package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Ignore
    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item{id=" + item.getId() + ", name='" + item.getName()
                        + "', created=" + item.getCreated() + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Show all items ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFyndById() {
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindById(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find an Item by Id ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item{id=" + item.getId() + ", name='" + item.getName()
                        + "', created=" + item.getCreated() + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find an Item by Id ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFyndByKey() {
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByKea(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Find Items by name ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
                        + "Item{id=" + item.getId() + ", name='" + item.getName()
                        + "', created=" + item.getCreated() + "}" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Find Items by name ===" + System.lineSeparator()
                        + "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit ===%n"
                )
        ));
    }
}
