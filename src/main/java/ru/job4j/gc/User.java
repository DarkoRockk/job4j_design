package ru.job4j.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d", number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new User();
        }
    }

}
