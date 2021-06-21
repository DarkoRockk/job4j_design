package ru.job4j.product;

import java.util.Calendar;

public class Egg extends Food {

    public Egg(String name, Calendar expiryDate, Calendar createDate, float price) {
        super(name, expiryDate, createDate, price);
    }
}
