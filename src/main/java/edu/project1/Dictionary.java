package edu.project1;

import java.util.List;
import java.util.Random;

public final class Dictionary {

    static List<String> dictionary = List.of("slava", "java", "backend");
    static Random random = new Random();

    private Dictionary() {
    }

    public static String getWord() {
        return dictionary.get(random.nextInt(dictionary.size()));
    }
}
