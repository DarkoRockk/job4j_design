package ru.job4j.product;

import java.util.GregorianCalendar;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Food cheese1 = new Cheese("Российский", new GregorianCalendar(2021, 0, 11),
                new GregorianCalendar(2021, 4, 25), 500);
        Food cheese2 = new Cheese("Голландский", new GregorianCalendar(2021, 0, 25),
                new GregorianCalendar(2021, 6, 11), 500);
        Food milk1 = new Cheese("Домик в деревне", new GregorianCalendar(2021, 5, 25),
                new GregorianCalendar(2022, 0, 11), 500);
        Food milk2 = new Cheese("Веелый молочник", new GregorianCalendar(2021, 4, 25),
                new GregorianCalendar(2021, 6, 11), 500);
        List<Storage> list = List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        );

        ControlQuality control = new ControlQuality(list);
        control.sort(cheese1);
        control.sort(cheese2);
        control.sort(milk1);
        control.sort(milk2);

        for(Storage s : list) {
            s.printList();
        }
    }
}
