package ru.job4j.parking;

public class Parking {

    private Car[] lightCars;
    private Car[] heavyCars;
    private int passPlaces = 0;
    private int truckPlaces = 0;

    public Parking(int passPlaces, int truckPlaces) {
        this.lightCars = new Car[passPlaces];
        this.heavyCars = new Car[truckPlaces];
    }

    public boolean park(Car car) {
        boolean rsl = false;
        if (car.getSize() == 1) {
            if (passPlaces < lightCars.length) {
                lightCars[passPlaces++] = car;
                rsl = true;
            }
        } else {
            if (truckPlaces < heavyCars.length) {
                heavyCars[truckPlaces++] = car;
                rsl = true;
            } else {
                if (lightCars.length - passPlaces >= car.getSize()) {
                    while (passPlaces <= car.getSize()) {
                        lightCars[passPlaces++] = car;
                    }
                    rsl = true;
                }
            }
        }
        return rsl;
    }
}
