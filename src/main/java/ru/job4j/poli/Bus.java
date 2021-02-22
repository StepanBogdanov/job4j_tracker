package ru.job4j.poli;

public class Bus implements Transport, Vehicle {

    @Override
    public void drive() {
        System.out.println("Едем");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Везем " + number + " пассажира");
    }

    @Override
    public float refuel(float fuel) {
        float price = 43.5f;
        return fuel * price;
    }

    @Override
    public void move() {
        System.out.println("Едем.");
    }
}
