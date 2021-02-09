package ru.job4j.poli;

public class Terminal {

    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{plane, bus, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
