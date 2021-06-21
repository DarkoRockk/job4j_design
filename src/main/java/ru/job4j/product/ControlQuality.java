package ru.job4j.product;

public class ControlQuality implements Sorter {

    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void sort(Food food) {
        // if food.....
        // warehouse or shop or trash.add(food)....
    }
}
