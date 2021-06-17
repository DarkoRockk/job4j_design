package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.List;

public class AreaCalcuator extends Calculator<Double> {
    private final ArrayList<Figure> figures;

    public AreaCalcuator(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public double squareSum() {
        double rsl = 0;
        for (Figure fig : figures) {
            if (fig.getType().equals("Circle")) {
                rsl += calculate((i, j) -> (i * j * 3.14), fig.getLength1(), fig.getLength2());
            } else if (fig.getType().equals("Square")) {
                rsl += calculate((i, j) -> (i * j), fig.getLength1(), fig.getLength2());
            }
        }
        return rsl;
    }
}
