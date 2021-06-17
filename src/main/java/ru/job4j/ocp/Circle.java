package ru.job4j.ocp;

public class Circle implements Figure {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public double getLength1() {
        return getRadius();
    }

    @Override
    public double getLength2() {
        return getRadius();
    }


}
