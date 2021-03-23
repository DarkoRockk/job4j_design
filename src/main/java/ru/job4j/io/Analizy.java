package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String[] tmp = {
                    "0", "0"
            };
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            while (in.ready()) {
                String[] el = in.readLine().split(" ");
                if (Integer.parseInt(el[0]) >= 400) {
                    if (Integer.parseInt(tmp[0]) < 400) {
                        tmp = el;
                    }
                } else {
                    if (Integer.parseInt(tmp[0]) >= 400) {
                        out.println(tmp[1] + ";" + el[1] + ";");
                        tmp = el;
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy an = new Analizy();
        an.unavailable("/Users/darkorockk/IdeaProjects/job4j_design/server_log.txt",
                "/Users/darkorockk/IdeaProjects/job4j_design/unavalable.txt");
    }
}
