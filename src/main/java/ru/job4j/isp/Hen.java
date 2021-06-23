package ru.job4j.isp;

import jdk.jshell.spi.ExecutionControl;

public class Hen extends Bird implements BirdBehavior {

    public Hen(String name, int age) {
        super(name, age);
    }

    @Override
    public String run() {
        return "Hen running";
    }

    @Override
    public String fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String makeSound() {
        return "cococo";
    }
}
