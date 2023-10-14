package edu.hw1;

public class Task7 {

    static final String EXCEPTION_MESSAGE = "Only positive values for 'n' and 'shift' are allowed";

    private Task7() {

    }

    public static int rotateLeft(int n, int shift) throws NumberFormatException {
        if ((n <= 0) | (shift <= 0)) {
            throw new NumberFormatException(EXCEPTION_MESSAGE);
        }
        String nBit = Integer.toBinaryString(n);

        int[] list = new int[nBit.length()];
        for (int i = 0; i < nBit.length(); i++) {
            list[i] = Character.getNumericValue(nBit.charAt(i));
        }
        int[] temp = new int[list.length];
        System.arraycopy(list, 0, temp, 0, shift);
        for (int i = shift; i < list.length; i++) {
            list[i - shift] = list[i];
        }
        System.arraycopy(temp, 0, list, list.length - shift, shift);
        StringBuilder result = new StringBuilder();
        for (int i : list) {
            result.append(i);
        }
        return Integer.parseInt(result.toString(), 2);
    }

    public static int rotateRight(int n, int shift) throws NumberFormatException {
        if ((n <= 0) | (shift <= 0)) {
            throw new NumberFormatException(EXCEPTION_MESSAGE);
        }
        String nBit = Integer.toBinaryString(n);

        int[] list = new int[nBit.length()];

        for (int i = 0; i < nBit.length(); i++) {
            list[i] = Character.getNumericValue(nBit.charAt(i));
        }
        int[] temp = new int[list.length - shift];
        if (list.length - shift >= 0) {
            System.arraycopy(list, 0, temp, 0, list.length - shift);
        }
        for (int i = list.length - shift; i < list.length; i++) {
            list[i - list.length + shift] = list[i];
        }
        System.arraycopy(temp, 0, list, shift, list.length - shift);
        StringBuilder result = new StringBuilder();
        for (int i : list) {
            result.append(i);
        }
        return Integer.parseInt(result.toString(), 2);
    }
}


