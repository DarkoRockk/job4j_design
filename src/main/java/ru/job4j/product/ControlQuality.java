package ru.job4j.product;

import java.util.List;

public class ControlQuality {

    private List<Storage> list;

    public ControlQuality(List<Storage> list) {
        this.list = list;
    }

    public void sort(Food food) {
        for(Storage store : list) {
            if(store.accept(food)) {
                store.add(food);
            }
        }
    }
}
