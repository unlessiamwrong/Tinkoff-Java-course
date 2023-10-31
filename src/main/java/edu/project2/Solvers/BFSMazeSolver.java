package edu.project2.Solvers;

import edu.project2.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("MultipleStringLiterals")
public class BFSMazeSolver {

    private BFSMazeSolver() {

    }

    public static boolean solve(String[][] maze, int x, int y) {
        int sideLength = maze.length;
        if ((x < 0 || x > sideLength) || (y < 0 || y > sideLength) || maze[x][y].equals("WALL")) {
            throw new NumberFormatException("Incorrect cell. Must be Passage and be inside the field.");
        }

        String exitCell = x + " " + y;
        List<String> unvisited = new ArrayList<>();
        Queue<String> queueCell = new LinkedList<>();
        String[][] path = new String[sideLength][sideLength];
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (maze[i][j].equals("PASSAGE") || maze[i][j].equals("DESTROYED_WALL")) {
                    unvisited.add(i + " " + j);
                }
            }
        }

        var cur = unvisited.remove(0);
        queueCell.add(cur);
        while (!queueCell.isEmpty()) {
            var currentCell = queueCell.poll();
            if (currentCell.equals(exitCell)) {
                BFSMazeSolver.buildPath(maze, path, exitCell);
                return true;
            }
            String[] parsedCurrentCell = currentCell.split(" ");
            int a = Integer.parseInt(parsedCurrentCell[0]);
            int b = Integer.parseInt(parsedCurrentCell[1]);
            var neighbors = Utility.getNeighborsForSolver(a, b, unvisited);
            if (!neighbors.isEmpty()) {
                for (var neighbor : neighbors) {
                    String[] parsedNeighbor = neighbor.split(" ");
                    int k = Integer.parseInt(parsedNeighbor[0]);
                    int l = Integer.parseInt(parsedNeighbor[1]);
                    path[k][l] = currentCell;
                    queueCell.add(neighbor);
                    unvisited.remove(neighbor);
                }
            }
        }
        return false;
    }

    public static void buildPath(String[][] maze, String[][] path, String exitCell) {
        String startCell = "1 1";
        maze[1][1] = "WAY_OUT";
        List<String> result = new ArrayList<>();
        var currentCell = exitCell;

        while (!currentCell.equals(startCell)) {
            result.add(currentCell);
            String[] temp = currentCell.split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            currentCell = path[x][y];
        }

        result.add(startCell);
        Collections.reverse(result);
        for (var x : result) {
            String[] temp = x.split(" ");
            int i = Integer.parseInt(temp[0]);
            int j = Integer.parseInt(temp[1]);
            maze[i][j] = "WAY_OUT";
        }
    }
}
