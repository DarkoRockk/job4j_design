package ru.job4j.isp;

public class Penguin extends Bird implements BirdBehavior {

    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public String run() {
        return "Penguin running";
    }

    @Override
    public String fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String makeSound() {
        return "AAAAAAAAA";
    }
}
