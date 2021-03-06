package ru.job4j.product;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Storage {

    @Override
    public void printList() {
        System.out.println("Warehouse products:");
        for (Food f : this.list) {
            System.out.println(f.toString());
            System.out.println();
        }
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        double index = Storage.getIndex(food);
        if (index <= 0.25) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void add(Food food) {
        this.list.add(food);
    }
}
