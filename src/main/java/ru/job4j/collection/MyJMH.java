package ru.job4j.collection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class MyJMH {

    private static final int ITEM_COUNT = 100_000;

    @State(Scope.Benchmark)
    public static class BenchmarkState {

        private LinkedArray<Object> link = new LinkedArray<>();
        private SimpleArray<Object> simp = new SimpleArray<>();

        public BenchmarkState() {
            for (int i = 0; i < ITEM_COUNT; i++) {
                link.add(new Object());
                simp.add(new Object());
            }
        }
    }

    @Benchmark
    public void testLinkedArray(BenchmarkState state) {
        state.link.get(555);
    }

    @Benchmark
    public void testSimpleArray(BenchmarkState state) {
        state.simp.get(555);

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyJMH.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }


}
