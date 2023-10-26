package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {

    public static PriorityQueue<Stock> stocks =
        new PriorityQueue<>(Comparator.comparingInt(Stock::getStockPrice).reversed());

    private Task6() {

    }

    public static void add(Stock stock) {
        stocks.add(stock);

    }

    public static void remove(Stock stock) {
        stocks.remove(stock);

    }

    public static Stock mostValuableStock() {
        return stocks.peek();
    }
}
