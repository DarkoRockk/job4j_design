package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Emulator {

    public static DirFileCache file;
    public static int action;
    public static String dir;

    public static void menu() throws IOException {
        System.out.println("Choose action:\n"
                + "1. Enter cached directory.\n"
                + "2. Load file into cache.\n"
                + "3. Get file from cache.\n"
                + "4. Exit.\n"
                + "========================\n"
                + "Current cache directory: "
                + dir + "\n");
    }

    public static void start() throws IOException {
        menu();
        init();
    }

    public static void init() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number:");
        try {
            action = Integer.parseInt(reader.readLine());
            switch (action) {
                case 1:
                    System.out.println("Please, enter cached directory:");
                    dir = reader.readLine();
                    System.out.println("Successful.");
                    System.out.println();
                    start();
                case 2:
                    file = new DirFileCache(dir);
                    System.out.println("Successful.");
                    System.out.println();
                    start();
                case 3:
                    System.out.println("Please, enter key:");
                    String key = reader.readLine();
                    if (file == null) {
                        file = new DirFileCache(key);
                    }
                    System.out.println("File content:");
                    System.out.println(file.get(key));
                    start();
                case 4:
                    break;
                default:
                    throw new IllegalArgumentException();
            }

        } catch (NumberFormatException e) {
            System.out.println("Wrong number format, please enter again.");
            init();
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong action number, please enter again.");
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        start();
    }
}
