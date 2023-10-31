package edu.project2.Solvers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Utility.getNeighborsForSolver;

@SuppressWarnings("MultipleStringLiterals")
public class DFSMazeSolver {

    private DFSMazeSolver() {

    }

    public static boolean solve(String[][] maze, int x, int y) {
        int sideLength = maze.length;
        if ((x < 0 || x > sideLength) || (y < 0 || y > sideLength) || maze[x][y].equals("WALL")) {
            throw new NumberFormatException("Incorrect cell. Must be Passage and be inside the field.");
        }

        String exitCell = x + " " + y;
        List<String> unvisited = new ArrayList<>();
        Stack<String> cellStack = new Stack<>();
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (maze[i][j].equals("PASSAGE") || maze[i][j].equals("DESTROYED_WALL")) {
                    unvisited.add(i + " " + j);
                }
            }
        }

        maze[1][1] = "WAY_OUT";
        String currentCell = unvisited.remove(0);
        while (true) {
            if (exitCell.equals(currentCell)) {
                return true;
            }
            String[] parsedCurrentCell = currentCell.split(" ");
            int i = Integer.parseInt(parsedCurrentCell[0]);
            int j = Integer.parseInt(parsedCurrentCell[1]);
            ArrayList<String> randomPickList = getNeighborsForSolver(i, j, unvisited);
            if (!randomPickList.isEmpty()) {
                cellStack.add(currentCell);
                Random random = new Random();
                String neighbor = randomPickList.get(random.nextInt(randomPickList.size()));
                String[] parsedNeighbor = neighbor.split(" ");
                int k = Integer.parseInt(parsedNeighbor[0]);
                int l = Integer.parseInt(parsedNeighbor[1]);
                maze[k][l] = "WAY_OUT";
                unvisited.remove(neighbor);
                currentCell = neighbor;
            } else if (!cellStack.isEmpty()) {
                currentCell = cellStack.pop();
            } else {
                return false;
            }

        }
    }
}



