package edu.hw1;

@SuppressWarnings("MagicNumber")
public final class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Only positive numbers are allowed");
        }
        String numStr = String.valueOf(num);
        if (numStr.length() % 2 != 0) {
            throw new Exception("Only even amount of digits is allowed");
        }
        int numInt = Integer.parseInt(numStr);
        int reversed = 0;
        while (numInt > 0) {
            int lastDigit = numInt % 10;
            reversed = reversed * 10 + lastDigit;
            numInt /= 10;
        }

        if (Integer.parseInt(numStr) == reversed) {
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
}
