package ru.job4j.product;

import java.util.Calendar;

public class Meat extends Food {
    public Meat(String name, Calendar expiryDate, Calendar createDate, float price) {
        super(name, expiryDate, createDate, price);
    }
}
