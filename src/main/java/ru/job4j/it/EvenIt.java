package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
       for (int i = point; i < numbers.length; i++) {
           if (numbers[i] % 2 == 0) {
               return true;
           }
       }
       return false;
    }

    @Override
    public Integer next() {
        if (point == numbers.length - 1) {
            if (numbers[point] % 2 == 0) {
                return numbers[point];
            }
            throw new NoSuchElementException();
        }
        while (numbers[point] % 2 != 0 && point < numbers.length - 1) {
            point++;
        }
        return numbers[point++];
    }
}
