package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class ReportJSON implements Report, Serializable {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Calendar.class, new CalendarAdapterJson());
        builder.registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson());
        Gson gson = builder.create();
        Employees employees = new Employees(store.findBy(filter));
        String json = gson.toJson(employees);
//        StringBuilder text = new StringBuilder();
//        text.append("[").append(System.lineSeparator());
//        for (Employee employee : store.findBy(filter)) {
//            String json = gson.toJson(employee);
//            text.append(json);
//            text.append(",").append(System.lineSeparator());
//        }
//        text.append("]");
//        return text.toString();
        return json;
    }
}
