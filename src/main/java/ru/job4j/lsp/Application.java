package ru.job4j.lsp;

public class Application {

    protected String processor;
    protected float hz;
    protected int coreCount;
    protected String video;

    public Application(String processor, float hz, int coreCount, String video) {
        this.processor = processor;
        this.hz = hz;
        this.coreCount = coreCount;
        this.video = video;
    }

    public String getProcessor() {
        return processor;
    }

    public float getHz() {
        return hz;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public String getVideo() {
        return video;
    }

    public void launch(Computer computer) {
        if (computer.getCoreCount() < 2 && computer.hz < 1.5) {
            System.out.println("It's too weak computer");
        }
    }
}
