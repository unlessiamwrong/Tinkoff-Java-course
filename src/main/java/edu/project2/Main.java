package edu.project2;

import edu.project2.Generators.DFSMazeGenerator;
import edu.project2.Solvers.BFSMazeSolver;

@SuppressWarnings({"RegexpSinglelineJava", "MagicNumber"})
public class Main {

    private Main() {

    }

    public static void main(String[] args) {
        // example how to create and solve maze
        var temp = DFSMazeGenerator.generate(15, 15);
        Utility.printMaze(temp);
        System.out.println(" ");
        var result = BFSMazeSolver.solve(temp, 13, 13);

        if (result) {
            Utility.printMaze(temp);
        }
    }
}

