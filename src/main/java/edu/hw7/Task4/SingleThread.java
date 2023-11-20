package edu.hw7.Task4;

import java.util.Random;

@SuppressWarnings("MagicNumber")
public class SingleThread {

    private static final Random RANDOM = new Random();

    private SingleThread() {

    }

    public static float singleThreadPiCount(int totalCount) {
        int circleCount = 0;
        for (int i = 0; i < totalCount; i++) {
            float x = RANDOM.nextFloat(0, 1);
            float y = RANDOM.nextFloat(0, 1);
            if (Math.pow(x, 2) + Math.pow(y, 2) < 1) {
                circleCount++;
            }
        }
        return 4 * ((float) circleCount / totalCount);
    }
}
