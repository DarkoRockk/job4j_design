package ru.job4j.dip;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PersonSelector {
    private MySQLConnection cn;
    private ArrayList<Person> list = new ArrayList<>();

    public PersonSelector(MySQLConnection cn) {
        this.cn = cn;
    }

    public void filter(Predicate<Person> predicate) {
        //some logic
    }

    public ArrayList<Person> getList() {
        return null;
    }
}
