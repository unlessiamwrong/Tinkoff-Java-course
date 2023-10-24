package edu.hw3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static List<String> parseContacts(String[] names, String sortType) {
        List<String> list = Arrays.asList(names);
        list.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String[] nameSurnameOne = o1.split("\\s");
                String[] nameSurnameTwo = o2.split("\\s");
                if (sortType.equals("ASC")) {
                    return nameSurnameOne[1].compareTo(nameSurnameTwo[1]);
                }
                return -(nameSurnameOne[1].compareTo(nameSurnameTwo[1]));
            }
        });
        return list;

    }
}
