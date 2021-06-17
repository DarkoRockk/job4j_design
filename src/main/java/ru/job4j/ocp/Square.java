package ru.job4j.ocp;

public class Square extends Circle {
    private final double length1;
    private final double length2;

    public Square(double length1, double length2) {
        this.length1 = length1;
        this.length2 = length2;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public double getLength1() {
        return length1;
    }

    @Override
    public double getLength2() {
        return length2;
    }
}
