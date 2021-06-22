package ru.job4j.product;


import java.util.Calendar;

public interface Storage {

    boolean accept(Food food);

    void add (Food food);

    void printList();

    static double getIndex(Food food) {
        long create = food.getCreateDate().getTimeInMillis();
        long expired = food.getExpiryDate().getTimeInMillis();
        long now = Calendar.getInstance().getTimeInMillis();
        long fromStart = expired - create;
        long fromToday = now - create;
        return (double) fromToday / (double) fromStart;
    };

}
