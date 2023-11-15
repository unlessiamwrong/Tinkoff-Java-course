package edu.hw5;

public class Task6 {

    private Task6() {

    }

    public static boolean isSubsequence(String s, String t) {
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            regex.append((s.charAt(i)));
            regex.append(".*");
        }
        return t.matches(String.valueOf(regex));
    }
}
