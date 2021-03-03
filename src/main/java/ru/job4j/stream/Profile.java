package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public Address getAddress() {
        return address;
    }

    public Profile(Address address) {
        this.address = address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(pr -> pr.address)
                .sorted((ad1, ad2) -> ad1.getCity().compareTo(ad2.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
