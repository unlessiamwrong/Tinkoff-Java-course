package edu.project2;

import com.diogonunes.jcolor.AnsiFormat;
import java.util.Arrays;
import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BLACK_TEXT;
import static com.diogonunes.jcolor.Attribute.BLUE_BACK;
import static com.diogonunes.jcolor.Attribute.BOLD;
import static com.diogonunes.jcolor.Attribute.GREEN_TEXT;
import static com.diogonunes.jcolor.Attribute.RED_BACK;

public class Main {

    public static void main(String[] args) {
        int height = 15;
        int width = 15;
        String[][] maze = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    maze[i][j] = "█";
                } else {
                    maze[i][j] = "░";
                }
            }

        }

        for (String[]x : maze) {
            StringBuilder result = new StringBuilder();
            for(String y: x)
                result.append(y);
            System.out.println(result);
        }

    }
}
