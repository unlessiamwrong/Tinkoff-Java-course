package edu.project2.Generators;

import edu.project2.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Utility.getNeighborsDFSGenerator;
import static edu.project2.Utility.removeWall;
import static edu.project2.Utility.setFieldDFSGenerator;

public class DFSMazeGenerator {
    static Random random = new Random();

    private DFSMazeGenerator() {

    }

    public static String[][] generate(int width, int height) {
        List<Cell> unvisited = new ArrayList<>();
        Stack<Cell> cellStack = new Stack<>();
        String[][] maze = setFieldDFSGenerator(width, height, unvisited);

        dfs(unvisited, cellStack, maze);
        return maze;
    }

    private static void dfs(List<Cell> unvisited, Stack<Cell> cellStack, String[][] maze) {
        Cell currentCell = unvisited.remove(0);
        while (!unvisited.isEmpty()) {
            ArrayList<Cell> randomPickList =
                getNeighborsDFSGenerator(currentCell.x, currentCell.y, unvisited);
            if (!randomPickList.isEmpty()) {
                cellStack.add(currentCell);
                Cell neighbor = randomPickList.get(random.nextInt(randomPickList.size()));
                removeWall(currentCell, neighbor, maze);
                unvisited.remove(neighbor);
                currentCell = neighbor;
            } else if (!cellStack.isEmpty()) {
                currentCell = cellStack.pop();
            }
        }
    }
}

