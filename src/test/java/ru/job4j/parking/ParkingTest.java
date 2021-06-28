package ru.job4j.parking;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ParkingTest {

    @Test
    public void whenAllRight() {
        Parking parking = new Parking(1, 1);
        Car light = new PassengerCar("Octavia");
        Car truck = new Truck("Kamaz", 3);
        boolean rsl1 = parking.park(light);
        boolean rsl2 = parking.park(truck);
        assertThat(rsl1, is(true));
        assertThat(rsl2, is(true));
    }

    @Test
    public void whenMoreThanNeed() {
        Parking parking = new Parking(1, 1);
        Car light = new PassengerCar("Octavia");
        Car truck1 = new Truck("Kamaz", 3);
        Car truck2 = new Truck("Scania", 3);
        parking.park(light);
        parking.park(truck1);
        boolean rsl3 = parking.park(truck2);
        assertThat(rsl3, is(false));
    }

    @Test
    public void whenTruckToPassenger() {
        Parking parking = new Parking(4, 1);
        Car light = new PassengerCar("Octavia");
        Car truck1 = new Truck("Kamaz", 3);
        Car truck2 = new Truck("Scania", 3);
        parking.park(light);
        parking.park(truck1);
        boolean rsl3 = parking.park(truck2);
        assertThat(rsl3, is(true));
    }

}