package ru.job4j.parking;

public class PassengerCar extends Car implements CanPark {

    public PassengerCar(String model, int size) {
        super(model, size);
    }

    @Override
    public int[] findPlace(Parking parking, Car car) {
        return new int[0];
    }
}
