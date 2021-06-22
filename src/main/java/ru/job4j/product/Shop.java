package ru.job4j.product;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    List<Food> list = new ArrayList<>();

    @Override
    public void printList() {
        System.out.println("Shop products:");
        for (Food f : this.list) {
            System.out.println(f.toString());
            System.out.println();
        }
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        double index = Storage.getIndex(food);
        if (index > 0.25 && index <= 0.75) {
            rsl = true;
        } else if (index > 0.75 && index < 1) {
            food.setDiscount(25);
            food.setPrice((food.getPrice() / 100) * (100 - food.getDiscount()));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void add(Food food) {
        this.list.add(food);
    }
}
