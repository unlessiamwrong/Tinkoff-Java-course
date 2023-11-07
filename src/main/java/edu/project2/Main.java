package edu.project2;

import edu.project2.Solvers.BFSMazeSolver;
import java.util.Arrays;

@SuppressWarnings({"RegexpSinglelineJava", "MagicNumber", "MultipleStringLiterals"})
public class Main {

    private Main() {

    }

    public static void main(String[] args) {
        // example how to create and solve maze
        String[][] maze = {{"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"},
            {"WALL", "PASSAGE", "WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "DESTROYED_WALL", "WALL", "WALL", "WALL", "DESTROYED_WALL", "WALL"},
            {"WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "DESTROYED_WALL", "WALL"},
            {"WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"}};
        var result = BFSMazeSolver.solve(maze, 1, 5);
        if (result) {
            System.out.println(Arrays.deepToString(maze));
            Utility.printMaze(maze);
        }

    }
}

