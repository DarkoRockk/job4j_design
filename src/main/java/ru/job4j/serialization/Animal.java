package ru.job4j.serialization;

import java.util.Arrays;

public class Animal {

    private boolean sex;
    private int age;
    private String name;
    private Vaccination vaсcine;
    private String[] statuses;

    public Animal(boolean sex, int age, String name, Vaccination vaccine, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.vaсcine = vaccine;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Animal{"
                + "sex=" + sex
                + ", age=" + age
                + ", name='" + name + '\''
                + ", vaсcine=" + vaсcine
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
