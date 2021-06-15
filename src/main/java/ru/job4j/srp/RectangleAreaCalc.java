package ru.job4j.srp;

public class RectangleAreaCalc implements AreaCalculator {

    private Rectangle rectangle;

    public RectangleAreaCalc(double width, double height) {
        this.rectangle = new Rectangle(width, height);
    }

    @Override
    public double getArea() {
        return rectangle.getWidth() * rectangle.getHeight();
    }
}
