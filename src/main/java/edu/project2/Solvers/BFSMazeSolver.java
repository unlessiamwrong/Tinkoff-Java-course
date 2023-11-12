package edu.project2.Solvers;

import edu.project2.Cell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static edu.project2.Utility.getNeighborsBFSSolver;

@SuppressWarnings("MultipleStringLiterals")
public class BFSMazeSolver {

    private BFSMazeSolver() {

    }

    public static boolean solve(String[][] maze, int x, int y) {
        int sideLength = maze.length;
        if ((x < 0 || x > sideLength) || (y < 0 || y > sideLength) || maze[x][y].equals("WALL")) {
            throw new NumberFormatException("Incorrect cell. Must be Passage and be inside the field.");
        }

        Cell exitCell = new Cell(x, y);
        Queue<Cell> queueCell = new LinkedList<>();
        Cell[][] path = new Cell[sideLength][sideLength];
        return bfs(maze, path, queueCell, exitCell);

    }

    private static boolean bfs(String[][] maze, Cell[][] path, Queue<Cell> queueCell, Cell exitCell) {
        queueCell.add(new Cell(1, 1));
        path[1][1] = new Cell(1, 1);
        while (!queueCell.isEmpty()) {
            Cell currentCell = queueCell.poll();
            if (currentCell.x == exitCell.x && currentCell.y == exitCell.y) {
                BFSMazeSolver.buildPath(maze, path, exitCell);
                return true;
            }
            ArrayList<Cell> neighbors =
                getNeighborsBFSSolver(currentCell.x, currentCell.y, path, maze);
            if (!neighbors.isEmpty()) {
                for (var neighbor : neighbors) {
                    path[neighbor.x][neighbor.y] = currentCell;
                    queueCell.add(neighbor);
                }
            }
        }
        return false;

    }

    private static void buildPath(String[][] maze, Cell[][] path, Cell exitCell) {
        Cell startCell = new Cell(1, 1);
        maze[1][1] = "WAY_OUT";
        List<Cell> result = new ArrayList<>();
        Cell currentCell = exitCell;

        while (!(currentCell.x == startCell.x && currentCell.y == startCell.y)) {
            result.add(currentCell);
            currentCell = path[currentCell.x][currentCell.y];
        }

        result.add(startCell);
        Collections.reverse(result);
        for (Cell cell : result) {
            maze[cell.x][cell.y] = "WAY_OUT";
        }
    }
}
