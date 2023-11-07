package edu.project2.Generators;

import edu.project2.Cell;
import java.util.List;
import java.util.Random;
import static edu.project2.Utility.computeWay;
import static edu.project2.Utility.getPassagesPrimGenerator;
import static edu.project2.Utility.getWallsPrimGenerator;
import static edu.project2.Utility.sefFieldPrimGenerator;

@SuppressWarnings("ParameterAssignment")
public class PrimsMazeGenerator {

    static Random random = new Random();

    private PrimsMazeGenerator() {

    }

    public static String[][] generate(int width, int height) {
        String[][] maze = sefFieldPrimGenerator(width, height);
        int x = random.nextInt(height);
        int y = random.nextInt(width);
        maze[x][y] = "PASSAGE";
        Cell currentCell = new Cell(x, y);

        prim(currentCell, maze);
        return maze;
    }

    public static void prim(Cell currentCell, String[][] maze) {
        List<Cell> walls = getWallsPrimGenerator(currentCell, maze);

        while (!walls.isEmpty()) {
            Cell currentWall = walls.get(random.nextInt(walls.size()));
            List<Cell> cells = getPassagesPrimGenerator(currentWall, maze);
            currentCell = cells.get(random.nextInt(cells.size()));
            computeWay(currentCell, currentWall, maze);
            currentCell = currentWall;
            walls.addAll(getWallsPrimGenerator(currentCell, maze));
            walls.remove(currentWall);
        }
    }
}
