package edu.hw3;

import java.util.LinkedHashMap;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MagicNumber")
public class Task4 {

    private Task4() {

    }

    public static String convertToRoman(int number) {
        if (number <= 0) {
            throw new NumberFormatException("Romans didn't care about negative numbers. *Sigh*");
        }
        if (number > 3999) {
            throw new NumberFormatException("This method only works with numbers bellow 3999. Sorry:(");
        }

        LinkedHashMap<Integer, String> romanNumerals = getIntegerStringLinkedHashMap();
        StringBuilder result = new StringBuilder();
        int mutableNumber = number;

        for (var i : romanNumerals.entrySet()) {
            int arabNum = i.getKey();
            String romanNum = i.getValue();
            while (arabNum <= mutableNumber) {
                result.append(romanNum);
                mutableNumber -= arabNum;
            }
            if (mutableNumber <= 0) {
                break;
            }
        }
        return result.toString();
    }

    @NotNull private static LinkedHashMap<Integer, String> getIntegerStringLinkedHashMap() {
        LinkedHashMap<Integer, String> romanNumerals = new LinkedHashMap<>();
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
        return romanNumerals;
    }
}
