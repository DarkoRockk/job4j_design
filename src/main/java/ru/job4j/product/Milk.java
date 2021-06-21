package ru.job4j.product;

import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar expiryDate, Calendar createDate, float price) {
        super(name, expiryDate, createDate, price);
    }
}
