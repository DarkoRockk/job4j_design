package ru.job4j.parking;

public class Truck extends Car implements CanPark {

    public Truck(String model, int size) {
        super(model, size);
    }

    @Override
    public int[] findPlace(Parking parking, Car car) {
        return new int[0];
    }
}
