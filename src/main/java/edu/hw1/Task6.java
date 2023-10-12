package edu.hw1;

import java.util.Arrays;

@SuppressWarnings("MagicNumber")
public class Task6 {

    private Task6() {
    }

    public static int countK(int n) throws Exception {
        return helper(n, 0);
    }

    private static int helper(int n, int counter) throws Exception {
        if (n <= 1000) {
            throw new Exception("Number should be greater than 1000");
        }
        int length = (int) (Math.log10(n) + 1);
        var list = new int[length];
        int cnt = 0;
        int mutableN = n;
        while (mutableN > 0) {
            int temp = mutableN % 10;
            mutableN /= 10;
            list[cnt] = temp;
            cnt++;
        }
        Arrays.sort(list);
        StringBuilder greatestNum = new StringBuilder();
        StringBuilder lowestNum = new StringBuilder();
        for (int i : list) {
            lowestNum.append(i);
        }
        for (int j = list.length - 1; j >= 0; j--) {
            greatestNum.append(list[j]);
        }
        int result = Integer.parseInt(greatestNum.toString()) - Integer.parseInt(lowestNum.toString());

        if (result != 6174) {
            return helper(result, counter + 1);
        }
        return counter + 1;
    }
}
