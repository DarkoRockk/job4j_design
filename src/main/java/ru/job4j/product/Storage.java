package ru.job4j.product;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Food> list = new ArrayList<>();

    public void add(Food food) {
        this.list.add(food);
    }

    public List<Food> getProducts() {
        return this.list;
    }
}
