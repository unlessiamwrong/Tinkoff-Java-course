package edu.hw5;

public class Task7 {

    private Task7() {

    }

    public static boolean regex1(String str) {
        String regex = "[01]{2}0[01]*";
        return str.matches(regex);
    }

    public static boolean regex2(String str) {
        String regex = "([01])[01]*\\1$|^[01]";
        return str.matches(regex);
    }

    public static boolean regex3(String str) {
        String regex = "[01]{1,3}";
        return str.matches(regex);
    }
}
