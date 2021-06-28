package ru.job4j.product;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Storage {

    protected List<Food> list = new ArrayList<>();

    abstract boolean accept(Food food);

    abstract void add (Food food);

    abstract void printList();

    protected List<Food> getAndRemove() {
        List<Food> rsl = this.list;
        list = new ArrayList<>();
        return rsl;
    }

    static double getIndex(Food food) {
        long create = food.getCreateDate().getTimeInMillis();
        long expired = food.getExpiryDate().getTimeInMillis();
        long now = Calendar.getInstance().getTimeInMillis();
        long fromStart = expired - create;
        long fromToday = now - create;
        return (double) fromToday / (double) fromStart;
    }
}
