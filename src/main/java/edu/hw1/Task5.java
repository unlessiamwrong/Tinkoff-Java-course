package edu.hw1;

@SuppressWarnings("MagicNumber")
public final class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) throws NumberFormatException {
        if (num < 0) {
            throw new NumberFormatException("Only positive numbers are allowed");
        }
        String numStr = String.valueOf(num);
        if (numStr.length() % 2 != 0) {
            throw new NumberFormatException("Only even amount of digits is allowed");
        }
        int numInt = Integer.parseInt(numStr);

        int reversedNum = reverseNum(numInt);

        if (Integer.parseInt(numStr) == reversedNum) {
            return true;
        } else {
            StringBuilder descendantStr = new StringBuilder();
            for (int i = 0; i < numStr.length(); i += 2) {
                int summary =
                    Character.getNumericValue(numStr.charAt(i)) + Character.getNumericValue(numStr.charAt(i + 1));
                descendantStr.append(summary);

            }
            int descendantInt = Integer.parseInt(descendantStr.toString());
            return isPalindromeDescendant(descendantInt);
        }
    }

    private static int reverseNum(int num) {
        int reversed = 0;
        int mutableNum = num;
        while (mutableNum > 0) {
            int lastDigit = mutableNum % 10;
            reversed = reversed * 10 + lastDigit;
            mutableNum /= 10;
        }
        return reversed;
    }
}
