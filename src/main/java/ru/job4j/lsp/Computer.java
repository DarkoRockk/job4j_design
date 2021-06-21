package ru.job4j.lsp;

public class Computer {

    protected String processor;
    protected float hz;
    protected int coreCount;
    protected String video;

    public Computer(String processor, float hz, int coreCount, String video) {
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
}
