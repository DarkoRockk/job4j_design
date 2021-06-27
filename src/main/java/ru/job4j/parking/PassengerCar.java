package ru.job4j.parking;

public class PassengerCar extends Car implements CanPark {

    public PassengerCar(String model) {
        super(model);
    }

    @Override
    public int size() {
        return super.getSize();
    }
}
