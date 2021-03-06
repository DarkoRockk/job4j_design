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
    private List<String> answers = new ArrayList<>();
    private List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String phrase = reader.readLine();
            boolean isWork = true;
            while (!phrase.equals(OUT)) {
                log.add(phrase);
                if (phrase.equals(STOP)) {
                    isWork = false;
                }
                if (isWork) {
                    String answer = getAnswer();
                    System.out.println(answer);
                    log.add(answer);
                }
                if (phrase.equals(CONTINUE)) {
                    isWork = true;
                }
                phrase = reader.readLine();
            }
            writeLog(log);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path,
                Charset.forName("UTF-8"))));) {
            for (String el : log) {
                out.println(el);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAnswer() {
        if (answers.size() == 0) {
            takeAnswers(botAnswers);
        }
        int index = (int) (Math.random() * answers.size());
        return answers.get(index);
    }

    public void takeAnswers(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                answers.add(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./chat_log.txt", "./botAnswers.txt");
        cc.run();
    }
}
