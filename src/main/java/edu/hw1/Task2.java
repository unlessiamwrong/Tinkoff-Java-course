package edu.hw1;

@SuppressWarnings("MagicNumber")
public final class Task2 {

    private Task2() {
    }

    public static int countDigits(int num) {
        if (num == 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        }
        return (int) (Math.log10(num) + 1);
    }
}
