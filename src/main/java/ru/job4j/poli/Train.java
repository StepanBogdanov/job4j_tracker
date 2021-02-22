package ru.job4j.poli;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Трясемся...");
    }
}
