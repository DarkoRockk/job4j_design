package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            while (in.available() > 0) {
                text.append((char) in.read());
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            for (String str : numbers) {
                int num = Integer.parseInt(str);
                boolean rsl = num % 2 == 0;
                System.out.println("Число " + num + (rsl ? " - четное" : " - нечетное"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

