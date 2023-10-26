package edu.hw3;

import java.util.HashMap;

public class Task1 {

    private Task1() {

    }

    public static String atbash(String str) {
        if (str == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String reversedAlphabet = new StringBuilder(alphabet).reverse().toString();
        char[] alphabetCharsArray = alphabet.toCharArray();
        char[] reversedAlphabetCharsArray = reversedAlphabet.toCharArray();
        HashMap<Character, Character> dictionary = new HashMap<>();
        for (int i = 0; i < alphabet.length(); ++i) {
            Character letter = alphabetCharsArray[i];
            Character reversedLetter = reversedAlphabetCharsArray[i];
            dictionary.put(letter, reversedLetter);
        }

        for (int j = 0; j < str.length(); ++j) {
            char currentChar = str.charAt(j);
            if (!Character.isLetter(currentChar)) {
                result.append(currentChar);
            } else if (Character.isUpperCase(currentChar)) {
                char currentCharLowerCase = Character.toLowerCase(currentChar);
                result.append(Character.toUpperCase(dictionary.get(Character.toLowerCase(currentCharLowerCase))));
            } else {
                result.append(dictionary.get(currentChar));
            }

        }
        return result.toString();
    }
}
