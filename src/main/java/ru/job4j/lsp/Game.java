package ru.job4j.lsp;

public class Game extends Application {

    public Game(String processor, float hz, int coreCount, String video) {
        super(processor, hz, coreCount, video);
    }

    @Override
    public void launch(Computer computer) {
        if (computer.getClass() != GameComp.class) {
            System.out.println("It's not game computer");
        }
        if (computer.getClass() == CheapComp.class) {
            System.out.println("It's too weak computer");
        }
        //some logic
    }
}
