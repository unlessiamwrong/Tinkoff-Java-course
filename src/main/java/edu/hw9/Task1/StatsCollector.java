package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StatsCollector {

    private final double maxDouble = 1.7 * Math.pow(10, 308);
    private final double minDouble = -1.7 * Math.pow(10, 308);
    private final ConcurrentLinkedQueue<Stat> stats = new ConcurrentLinkedQueue<>();

    public StatsCollector() {

    }

    public void push(String name, double[] values) {
        double sum = 0.0;
        double max = minDouble;
        double min = maxDouble;
        for (double value : values) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            sum += value;
        }
        stats.add(new Stat(name, sum, sum / values.length, max, min));
    }

    public ArrayList<Stat> stats() {
        return new ArrayList<>(stats);
    }
}
