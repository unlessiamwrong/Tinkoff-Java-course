package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    static Pattern pattern = Pattern.compile("[~!@#$%^&*|]");

    private Task4() {

    }

    public static boolean validatePassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
