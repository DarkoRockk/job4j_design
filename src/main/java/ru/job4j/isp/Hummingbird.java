package ru.job4j.isp;

public class Hummingbird extends Animal implements BirdBehavior {

    public Hummingbird(String name, int age) {
        super(name, age);
    }

    @Override
    public String run() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String fly() {
        return "Hummingbird flies";
    }

    @Override
    public String makeSound() {
        throw new UnsupportedOperationException();
    }
}
