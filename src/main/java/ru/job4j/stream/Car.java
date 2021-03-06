package ru.job4j.stream;

public class Car {

    private String brand;
    private String model;
    private String bodyType;
    private byte numberOfPassengers;
    private short maxSpeed;
    private double accelerationTo100;

    static class Builder {

        private String brand;
        private String model;
        private String bodyType;
        private byte numberOfPassengers;
        private short maxSpeed;
        private double accelerationTo100;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildBodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        Builder buildNumbersOfPassengers(byte numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
            return this;
        }

        Builder buildMaxSpeed(short maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildAccelerationTo100(double accelerationTo100) {
            this.accelerationTo100 = accelerationTo100;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.bodyType = bodyType;
            car.numberOfPassengers = numberOfPassengers;
            car.maxSpeed = maxSpeed;
            car.accelerationTo100 = accelerationTo100;
            return car;
        }
    }
}
