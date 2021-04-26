package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isFlag() {
        return flag;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getMassive() {
        return massive;
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

        JSONObject jsonContact = new JSONObject("{\"zipcode\":300,\"phone\":\"123456789\"}");

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        JSONArray jsonMassive = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", test.isFlag());
        jsonObject.put("quantity", test.getQuantity());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("massive", jsonMassive);


        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(test).toString());
    }
}
