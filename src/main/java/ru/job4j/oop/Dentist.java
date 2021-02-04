package ru.job4j.oop;

public class Dentist extends Doctor{

    private int price;

    public int getPrice() {
        return price;
    }

    public boolean canHeal(Patient patient) {
        return patient.getMoney() >= price;
    }
}
