package edu.hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Task3 {

    private Task3() {

    }

    public static HashMap<String, Integer> freqDict(String[] listStr) {
        var setStr = new HashSet<>(Arrays.asList(listStr));
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (String uniqueStr : setStr) {
            dictionary.put(uniqueStr, 0);
        }
        for (String str : listStr) {
            if (dictionary.containsKey(str)) {
                int value = dictionary.get(str);
                dictionary.put(str, ++value);
            }
        }
        return dictionary;
    }
}
