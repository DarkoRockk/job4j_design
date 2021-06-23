package ru.job4j.parking;

public class Parking {

    private Car[] parking;
    private int passPlaces;
    private int truckPlaces;

    public Parking(int passPlaces, int truckPlaces) {
        this.passPlaces = passPlaces;
        this.truckPlaces = truckPlaces;
        this.parking = new Car[passPlaces + truckPlaces];
    }

    public Car[] getParking() {
        return parking;
    }

    public void setParking(Car[] parking) {
        this.parking = parking;
    }

    public int getPassPlaces() {
        return passPlaces;
    }

    public void setPassPlaces(int passPlaces) {
        this.passPlaces = passPlaces;
    }

    public int getTruckPlaces() {
        return truckPlaces;
    }

    public void setTruckPlaces(int truckPlaces) {
        this.truckPlaces = truckPlaces;
    }
}
