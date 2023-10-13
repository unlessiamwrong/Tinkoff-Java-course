package edu.hw1;

@SuppressWarnings("MagicNumber")
public final class Task1 {

    private Task1() {
    }

    public static int minutesToSeconds(String minutes) {
        if (minutes.length() > 10) {
            throw new NumberFormatException("The number is too large");

        }
        int colonIndex = minutes.indexOf(":");
        if (colonIndex == -1) {
            return -1;
        }
        try {
            Integer.parseInt(minutes.substring(colonIndex + 1));
        } catch (NumberFormatException e) {
            return -1;
        }
        int secondsBeforeConverting = Integer.parseInt(minutes.substring(colonIndex + 1));
        if (secondsBeforeConverting >= 60) {
            return -1;
        }
        return Integer.parseInt(minutes.substring(0, colonIndex)) * 60 + secondsBeforeConverting;
    }
}
