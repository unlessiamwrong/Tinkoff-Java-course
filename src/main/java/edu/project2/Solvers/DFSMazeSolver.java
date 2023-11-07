package edu.project2.Solvers;

import edu.project2.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.project2.Utility.getNeighborsDFSSolver;
import static edu.project2.Utility.markPassagesDFSSolver;

@SuppressWarnings("MultipleStringLiterals")
public class DFSMazeSolver {

    private DFSMazeSolver() {

    }

    public static boolean solve(String[][] maze, int x, int y) {
        int sideLength = maze.length;
        if ((x < 0 || x > sideLength) || (y < 0 || y > sideLength) || maze[x][y].equals("WALL")) {
            throw new NumberFormatException("Incorrect cell. Must be Passage and be inside the field.");
        }

        Cell exitCell = new Cell(x, y);
        List<Cell> unvisited = new ArrayList<>();
        Stack<Cell> cellStack = new Stack<>();
        markPassagesDFSSolver(maze, sideLength, unvisited);

        Cell currentCell = unvisited.remove(0);
        while (true) {
            if (currentCell.x == exitCell.x && currentCell.y == exitCell.y) {
                maze[x][y] = "WAY_OUT";
                return true;
            }
            ArrayList<Cell> randomPickList =
                getNeighborsDFSSolver(currentCell.x, currentCell.y, unvisited);
            if (!randomPickList.isEmpty()) {
                cellStack.add(currentCell);
                currentCell = pickNeighbor(randomPickList, maze, currentCell, unvisited);
            } else if (!cellStack.isEmpty()) {
                currentCell = cellStack.pop();
            } else {
                return false;
            }

        }
    }

    public static Cell pickNeighbor(
        ArrayList<Cell> randomPickList,
        String[][] maze,
        Cell currentCell,
        List<Cell> unvisited
    ) {
        Random random = new Random();
        Cell neighbor = randomPickList.get(random.nextInt(randomPickList.size()));
        maze[currentCell.x][currentCell.y] = "WAY_OUT";
        unvisited.remove(neighbor);
        return neighbor;
    }
}



