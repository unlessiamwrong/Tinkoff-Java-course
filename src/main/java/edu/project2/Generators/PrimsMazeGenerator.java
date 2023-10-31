package edu.project2.Generators;

import edu.project2.Utility;
import java.util.List;
import java.util.Random;

public class PrimsMazeGenerator {

    static Random random = new Random();

    private PrimsMazeGenerator() {

    }

    public static String[][] generate(int width, int height) {
        String[][] maze = new String[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = "WALL";
            }
        }

        int x = random.nextInt(height);
        int y = random.nextInt(width);
        maze[x][y] = "PASSAGE";
        String currentCell = x + " " + y;
        List<String> walls = Utility.getWallsForPrimGenerator(currentCell, maze);

        while (!walls.isEmpty()) {
            String currentWall = walls.get(random.nextInt(walls.size()));
            List<String> cells = Utility.getPassagesForPrimGenerator(currentWall, maze);
            currentCell = cells.get(random.nextInt(cells.size()));
            Utility.computeWay(currentCell, currentWall, maze);
            currentCell = currentWall;
            walls.addAll(Utility.getWallsForPrimGenerator(currentCell, maze));
            walls.remove(currentWall);
        }
        return maze;
    }
}
