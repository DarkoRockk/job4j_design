package ru.job4j.product;

import java.util.Calendar;

public class Fish extends Food {

    public Fish(String name, Calendar expiryDate, Calendar createDate, float price) {
        super(name, expiryDate, createDate, price);
    }
}
