package ru.job4j.poli;

public class Bus implements Transport, Vehicle{

    @Override
    public void drive() {

    }

    @Override
    public void passengers(int number) {

    }

    @Override
    public float refuel(float fuel) {
        return 0;
    }

    @Override
    public void move() {
        System.out.println("Едем.");
    }
}
