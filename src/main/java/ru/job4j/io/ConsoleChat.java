package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path,
                     Charset.forName("UTF-8"))))) {
            String phrase = reader.readLine();
            out.println(phrase);
            boolean isWork = true;
            while (!phrase.equals(OUT)) {
                out.println(phrase);
                if (phrase.equals(STOP)) {
                    isWork = false;
                }
                if (isWork) {
                    String answer = getAnswer();
                    System.out.println(answer);
                    out.println(answer);
                }
                if (phrase.equals(CONTINUE)) {
                    isWork = true;
                }
                phrase = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getAnswer() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            while (reader.ready()) {
                answers.add(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int index = (int) (Math.random() * answers.size());
        return answers.get(index);
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./chat_log.txt", "./botAnswers.txt");
        cc.run();
    }
}
