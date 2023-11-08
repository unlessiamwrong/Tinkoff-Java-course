package edu.hw5;

public class Task8 {

    private Task8() {

    }

    public static boolean regex1(String str) {
        return str.matches("[01](?:[01]{2})*");

    }

    public static boolean regex2(String str) {
        return str.matches("^0(?:[01]{2})*$|^1[01](?:[01]{2})*$");

    }

    public static boolean regex4(String str) {
        return str.matches("(?!11$)(?!111$)[01]*");

    }

    public static boolean regex8(String str) {
        return !str.matches("[01]*11[01]*");

    }
}
