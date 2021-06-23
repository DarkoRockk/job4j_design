package ru.job4j.isp;

public class Duck extends Bird implements BirdBehavior {


    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public String run() {
        return "Duck running";
    }

    @Override
    public String fly() {
        return "Duck flies";
    }

    @Override
    public String makeSound() {
        return "kryakryakrya";
    }
}
