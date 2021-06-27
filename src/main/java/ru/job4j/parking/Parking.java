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

    public Car[] getLightCars() {
        return lightCars;
    }

    public void setLightCars(Car[] lightCars) {
        this.lightCars = lightCars;
    }

    public Car[] getHeavyCars() {
        return heavyCars;
    }

    public void setHeavyCars(Car[] heavyCars) {
        this.heavyCars = heavyCars;
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

    public void park (Car car) {

    }
}
