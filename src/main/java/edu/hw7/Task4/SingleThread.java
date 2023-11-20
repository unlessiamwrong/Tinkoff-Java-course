package edu.hw7.Task4;

import java.util.Random;

public class SingleThread {

    private static final Random random = new Random();

    public static float singleThreadPiCount(int totalCount) {
        int circleCount = 0;
        for (int i = 0; i < totalCount; i++) {
            float x = random.nextFloat(0, 1);
            float y = random.nextFloat(0, 1);
            if (Math.pow(x, 2) + Math.pow(y, 2) < 1) {
                circleCount++;
            }
        }
        return 4 * ((float) circleCount / totalCount);
    }
}
