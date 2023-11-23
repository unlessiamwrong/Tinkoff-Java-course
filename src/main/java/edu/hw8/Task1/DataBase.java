package edu.hw8.Task1;

import java.util.Map;

public class DataBase {

    private static final Map<String, String> DB = Map.of(
        "fall",
        "The greatest glory in living lies not in never falling, but in rising every time we fall.",
        "talk",
        "The way to get started is to quit talking and begin doing.",
        "dream",
        "The future belongs to those who believe in the beauty of their dreams.",
        "goal",
        "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.",
        "scare",
        "Do one thing every day that scares you."
    );

    public static String get(String key) {
        return DB.get(key);

    }
}
