package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class JsonTest {

    private boolean flag;
    private int quantity;
    private String name;
    private Contact contact;
    private String[] massive;

    public JsonTest(boolean flag, int quantity, String name, Contact contact, String... massive) {
        this.flag = flag;
        this.quantity = quantity;
        this.name = name;
        this.contact = contact;
        this.massive = massive;
    }

    @Override
    public String toString() {
        return "JsonTest{"
                + "flag=" + flag
                + ", quantity=" + quantity
                + ", name='" + name + '\''
                + ", contact=" + contact
                + ", massive=" + Arrays.toString(massive)
                + '}';
    }

    public static void main(String[] args) {
        JsonTest test = new JsonTest(true, 43, "Joker",
                new Contact(300, "123456789"), "One", "Two");

        Gson gson = new GsonBuilder().create();
        String jsonTest = gson.toJson(test);
        System.out.println(jsonTest);

        JsonTest test1 = gson.fromJson(jsonTest, JsonTest.class);
        System.out.println(test1);
    }
}
