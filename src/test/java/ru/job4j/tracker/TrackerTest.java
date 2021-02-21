package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = Tracker.getInstance();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenAscendSort() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("C"));
        tracker.add(new Item("B"));
        tracker.add(new Item("A"));
        tracker.ascendSortByName();
        List<Item> items = tracker.findAll();
        List<String> rsl= new ArrayList<>();
        for (Item item : items) {
            rsl.add(item.getName());
        }
        List<String> expected = Arrays.asList("A", "B", "C");
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenDescendSort() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("A"));
        tracker.add(new Item("C"));
        tracker.add(new Item("B"));
        tracker.descentSortByName();
        List<Item> items = tracker.findAll();
        List<String> rsl= new ArrayList<>();
        for (Item item : items) {
            rsl.add(item.getName());
        }
        List<String> expected = Arrays.asList("C", "B", "A");
        assertThat(rsl, is(expected));
    }
}