package edu.project2;

import edu.project2.Generators.DFSMazeGenerator;
import edu.project2.Solvers.BFSMazeSolver;
import edu.project2.Solvers.DFSMazeSolver;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project2Tests {

    @Test
    public void DFSMazeGenerator_EqualsExpected_Test() {
        //Arrange
        String[][] expectedResult = {{"WALL", "WALL", "WALL"}, {"WALL", "PASSAGE", "WALL"}, {"WALL", "WALL", "WALL"}};
        int x = 3;
        int y = 3;

        //Act
        String[][] result = DFSMazeGenerator.generate(x, y);

        //Assert
        assertThat(result).isEqualTo(expectedResult);

    }

    @Test
    public void printMaze_EqualsExpected_Test() {
        //Arrange
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String[][] maze = {{"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"},
            {"WALL", "PASSAGE", "WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "DESTROYED_WALL", "WALL", "DESTROYED_WALL", "WALL", "WALL", "WALL"},
            {"WALL", "PASSAGE", "WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "DESTROYED_WALL", "WALL", "WALL", "WALL", "DESTROYED_WALL", "WALL"},
            {"WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"}};

        String expectedResult = """
            ██████████████
            ██░░██░░░░░░██
            ██░░██░░██████
            ██░░██░░░░░░██
            ██░░██████░░██
            ██░░░░░░░░░░██
            ██████████████
            """;

        //Act
        Utility.printMaze(maze);

        //Assert
        assertThat(outputStreamCaptor.toString().replaceAll("\n", "").replaceAll("\r", ""))
            .isEqualTo(expectedResult.replaceAll("\n", "").replaceAll("\r", ""));
    }

    @Test
    public void mazeSolver_IncorrectCords_ThrowsException_Test() {
        String[][] maze = DFSMazeGenerator.generate(15, 15);
        int x = 20;
        int y = 20;

        Assertions.assertThrows(NumberFormatException.class, () ->
            DFSMazeSolver.solve(maze, x, y));

        Assertions.assertThrows(NumberFormatException.class, () ->
            BFSMazeSolver.solve(maze, x, y));

    }

    @Test
    public void BFSSolver_BuildShortestPath_Test() {
        //Arrange
        String[][] maze = {{"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"},
            {"WALL", "PASSAGE", "WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "DESTROYED_WALL", "WALL", "WALL", "WALL", "DESTROYED_WALL", "WALL"},
            {"WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "DESTROYED_WALL", "WALL"},
            {"WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"}};

        String[][] expectedResult = {{"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"},
            {"WALL", "WAY_OUT", "WALL", "PASSAGE", "DESTROYED_WALL", "WAY_OUT", "WALL"},
            {"WALL", "WAY_OUT", "WALL", "WALL", "WALL", "WAY_OUT", "WALL"},
            {"WALL", "WAY_OUT", "WAY_OUT", "WAY_OUT", "WAY_OUT", "WAY_OUT", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "DESTROYED_WALL", "WALL"},
            {"WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "DESTROYED_WALL", "PASSAGE", "WALL"},
            {"WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"}};

        //Act
        boolean result = BFSMazeSolver.solve(maze, 1, 5);

        //Assert
        assertThat(result).isTrue();
        assertThat(maze).isEqualTo(expectedResult);

    }
}

