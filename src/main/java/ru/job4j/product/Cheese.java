package ru.job4j.product;

import java.util.Calendar;

public class Cheese extends Food {
    public Cheese(String name, Calendar expiryDate, Calendar createDate, float price) {
        super(name, expiryDate, createDate, price);
    }
}
