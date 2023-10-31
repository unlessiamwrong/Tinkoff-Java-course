package edu.hw3;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("MultipleStringLiterals")
public class Task5 {

    private Task5() {

    }

    public static List<String> parseContacts(String[] names, String sortType) {
        List<String> list = Arrays.asList(names);
        list.sort((o1, o2) -> {
            String[] nameSurnameOne = o1.split("\\s");
            String[] nameSurnameTwo = o2.split("\\s");
            if ("ASC".equals(sortType)) {
                return nameSurnameOne[1].compareTo(nameSurnameTwo[1]);
            }
            return -(nameSurnameOne[1].compareTo(nameSurnameTwo[1]));
        });
        return list;

    }
}
