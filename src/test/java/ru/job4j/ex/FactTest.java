package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test
    public void whenMoreThan0() {
        int rsl = new Fact().calc(4);
        assertThat(rsl, is(24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLessThan0() {
        int rsl = new Fact().calc(-2);
    }
}