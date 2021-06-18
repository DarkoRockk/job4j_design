package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.function.Predicate;

public class ReportJSON implements Report, Serializable {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().create();
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            String json = gson.toJson(employee);
            String[] jtext = json.split(",");
            for (String s : jtext) {
                if (s.contains("\"month\"")) {
                    String[] month = s.split(":");
                    String rsl = month[0] + ":" + (Integer.parseInt(month[1]) + 1);
                    text.append(rsl);
                } else {
                    text.append(s).append(",");
                }
            }
        }
        return text.toString();
    }
}
