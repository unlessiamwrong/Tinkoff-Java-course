package edu.hw6.Task3;

import java.util.regex.Pattern;

interface RegexFilter extends AbstractFilter {

    static AbstractFilter regexContains(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return path -> pattern.matcher(path.toString()).find();
    }

}
