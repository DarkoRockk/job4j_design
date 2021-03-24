package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String[] tmp = {
                    "0", "0"
            };
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                while (in.ready()) {
                    String[] el = in.readLine().split(" ");
                    if (Integer.parseInt(el[0]) >= 400) {
                        if (Integer.parseInt(tmp[0]) < 400) {
                            tmp = el;
                        }
                    } else {
                        if (Integer.parseInt(tmp[0]) >= 400) {
                            out.printf("%s;%s;%n", tmp[1], el[1]);
                            tmp = el;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy an = new Analizy();
        an.unavailable("./server_log.txt",
                "./unavalable.txt");
    }
}
