package ru.job4j.parking;

public class Parking {

    private Car[] lightCars;
    private Car[] heavyCars;
    private int passPlaces;
    private int truckPlaces;

    public Parking(int passPlaces, int truckPlaces) {
        this.passPlaces = passPlaces;
        this.truckPlaces = truckPlaces;
        this.lightCars = new Car[passPlaces];
        this.heavyCars = new Car[truckPlaces];
    }

    public boolean park(Car car) {
        return false;
    }
}
