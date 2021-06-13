package ru.job4j.gc;

import java.util.concurrent.TimeUnit;

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

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new User();
        }
        System.gc();
        TimeUnit.SECONDS.sleep(15);
    }

}
