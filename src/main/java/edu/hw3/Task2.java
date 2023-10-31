package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {

    }

    public static List<String> clusterize(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder tempStr = new StringBuilder();
        int leftParenthesisCount = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                tempStr.append(str.charAt(i));
                leftParenthesisCount++;
            } else if (str.charAt(i) == ')') {
                if (leftParenthesisCount <= 0) {
                    throw new RuntimeException("String is unbalanced");
                }
                tempStr.append(str.charAt(i));
                leftParenthesisCount--;
                if (leftParenthesisCount == 0) {
                    result.add(tempStr.toString());
                    tempStr = new StringBuilder();

                }
            }
        }
        return result;
    }
}
