package ru.job4j.stream;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Moscow", "Arbat", 33, 213)));
        profiles.add(new Profile(new Address("Rostov", "Lenina", 35, 12)));
    }

    @Test
    public void whenMapAddress() {
        List<Address> rsl = Profile.collect(profiles);
        List<Address> expected =  new ArrayList<>();
        expected.add(new Address("Moscow", "Arbat", 33, 213));
        expected.add(new Address("Rostov", "Lenina", 35, 12));
        assertThat(rsl, is(expected));
    }
}