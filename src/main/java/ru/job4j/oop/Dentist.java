package ru.job4j.oop;

public class Dentist extends Doctor {

    private int price;

    public Dentist(String name, String surname, String education, String birthday,
                   String degree, int price) {
        super(name, surname, education, birthday, degree);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean canHeal(Patient patient) {
        return patient.getMoney() >= price;
    }
}
