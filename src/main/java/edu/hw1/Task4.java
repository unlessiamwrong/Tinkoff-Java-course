package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        StringBuilder fixedString = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            var nextSymbol = (i + 2 > str.length()) ? "" : str.charAt(i + 1);
            fixedString.append(nextSymbol).append(str.charAt(i));
        }
        return fixedString.toString();
    }
}
