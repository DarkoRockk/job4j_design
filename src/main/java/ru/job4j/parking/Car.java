package ru.job4j.parking;

import java.util.Objects;

public abstract class Car {

    private String model;
    private int size;

    public Car(String model) {
        this.model = model;
        this.size = 1;
    }

    public Car(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return size == car.size && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, size);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", size=" + size +
                '}';
    }
}
