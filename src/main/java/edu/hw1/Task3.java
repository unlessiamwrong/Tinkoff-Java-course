package edu.hw1;

import java.util.Arrays;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        int a1Min = Arrays.stream(a1).min().orElseThrow();
        int a1Max = Arrays.stream(a1).max().orElseThrow();
        int a2Min = Arrays.stream(a2).min().orElseThrow();
        int a2Max = Arrays.stream(a2).max().orElseThrow();
        return a1Min > a2Min && a1Max < a2Max;
    }
}
