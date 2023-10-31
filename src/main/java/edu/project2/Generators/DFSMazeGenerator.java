package edu.project2.Generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Utility.getNeighborsForDFSGenerator;
import static edu.project2.Utility.removeWall;

public class DFSMazeGenerator {
    static Random random = new Random();

    private DFSMazeGenerator() {

    }

    public static String[][] generate(int width, int height) {
        List<String> unvisited = new ArrayList<>();
        Stack<String> cellStack = new Stack<>();
        String[][] maze = new String[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    maze[i][j] = "PASSAGE";
                    unvisited.add((i + " " + j));
                } else {
                    maze[i][j] = "WALL";
                }
            }
        }

        String currentCell = unvisited.remove(0);
        while (!unvisited.isEmpty()) {
            String[] parsedCurrentCell = currentCell.split(" ");
            int x = Integer.parseInt(parsedCurrentCell[0]);
            int y = Integer.parseInt(parsedCurrentCell[1]);
            ArrayList<String> randomPickList = getNeighborsForDFSGenerator(x, y, unvisited);
            if (!randomPickList.isEmpty()) {
                cellStack.add(currentCell);
                String neighbor = randomPickList.get(random.nextInt(randomPickList.size()));
                removeWall(currentCell, neighbor, maze);
                unvisited.remove(neighbor);
                currentCell = neighbor;
            } else if (!cellStack.isEmpty()) {
                currentCell = cellStack.pop();
            }
        }
        return maze;
    }
}

