package ru.job4j.product;

import java.util.Calendar;

public class Drink extends Food {

    public Drink(String name, Calendar expiryDate, Calendar createDate, float price) {
        super(name, expiryDate, createDate, price);
    }
}
