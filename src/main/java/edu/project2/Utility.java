package edu.project2;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"MultipleStringLiterals", "MagicNumber", "RegexpSinglelineJava", "MissingSwitchDefault"})
public class Utility {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private Utility() {

    }

    public static void removeWall(String unparsedCurrentCell, String unparsedNeighborCell, String[][] maze) {
        var currentCell = unparsedCurrentCell.split(" ");
        var neighborCell = unparsedNeighborCell.split(" ");
        int subtractionX = Integer.parseInt(currentCell[0]) - Integer.parseInt(neighborCell[0]);
        int subtractionY = Integer.parseInt(currentCell[1]) - Integer.parseInt(neighborCell[1]);

        if (subtractionX == 0) {
            if (subtractionY < 0) {
                maze[Integer.parseInt(currentCell[0])][Integer.parseInt(currentCell[1]) + 1] = "DESTROYED_WALL";
            } else {
                maze[Integer.parseInt(currentCell[0])][Integer.parseInt(currentCell[1]) - 1] = "DESTROYED_WALL";
            }

        }
        if (subtractionY == 0) {
            if (subtractionX < 0) {
                maze[Integer.parseInt(currentCell[0]) + 1][Integer.parseInt(currentCell[1])] = "DESTROYED_WALL";
            } else {
                maze[Integer.parseInt(currentCell[0]) - 1][Integer.parseInt(currentCell[1])] = "DESTROYED_WALL";
            }
        }
    }

    public static void computeWay(String unparsedCurrentCell, String unparsedNeighborCell, String[][] maze) {
        var currentCell = unparsedCurrentCell.split(" ");
        var neighborCell = unparsedNeighborCell.split(" ");
        int subtractionX = Integer.parseInt(currentCell[0]) - Integer.parseInt(neighborCell[0]);
        int subtractionY = Integer.parseInt(currentCell[1]) - Integer.parseInt(neighborCell[1]);
        maze[Integer.parseInt(neighborCell[0])][Integer.parseInt(neighborCell[1])] = "PASSAGE";

        if (subtractionX == 0) {
            if (subtractionY < 0) {
                maze[Integer.parseInt(currentCell[0])][Integer.parseInt(currentCell[1]) + 1] = "PASSAGE";
            } else {
                maze[Integer.parseInt(currentCell[0])][Integer.parseInt(currentCell[1]) - 1] = "PASSAGE";
            }

        }
        if (subtractionY == 0) {
            if (subtractionX < 0) {
                maze[Integer.parseInt(currentCell[0]) + 1][Integer.parseInt(currentCell[1])] = "PASSAGE";
            } else {
                maze[Integer.parseInt(currentCell[0]) - 1][Integer.parseInt(currentCell[1])] = "PASSAGE";
            }
        }
    }

    public static ArrayList<String> getNeighborsForDFSGenerator(int x, int y, List<String> unvisited) {
        ArrayList<String> randomPickList = new ArrayList<>();
        String positiveNeighborX = (x + 2) + " " + y;
        String positiveNeighborY = x + " " + (y + 2);
        String negativeNeighborX = (x - 2) + " " + y;
        String negativeNeighborY = x + " " + (y - 2);

        if (unvisited.contains(positiveNeighborX)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(positiveNeighborX)));
        }

        if (unvisited.contains(positiveNeighborY)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(positiveNeighborY)));
        }

        if (unvisited.contains(negativeNeighborX)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(negativeNeighborX)));
        }

        if (unvisited.contains(negativeNeighborY)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(negativeNeighborY)));
        }

        return randomPickList;
    }

    public static ArrayList<String> getNeighborsForSolver(int x, int y, List<String> unvisited) {
        ArrayList<String> randomPickList = new ArrayList<>();
        String positiveNeighborX = (x + 1) + " " + y;
        String positiveNeighborY = x + " " + (y + 1);
        String negativeNeighborX = (x - 1) + " " + y;
        String negativeNeighborY = x + " " + (y - 1);

        if (unvisited.contains(positiveNeighborX)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(positiveNeighborX)));
        }

        if (unvisited.contains(positiveNeighborY)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(positiveNeighborY)));
        }

        if (unvisited.contains(negativeNeighborX)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(negativeNeighborX)));
        }

        if (unvisited.contains(negativeNeighborY)) {
            randomPickList.add(unvisited.get(unvisited.indexOf(negativeNeighborY)));
        }

        return randomPickList;
    }

    public static List<String> getWallsForPrimGenerator(String cell, String[][] maze) {
        List<String> result = new ArrayList<>();
        String[] parsedCell = cell.split(" ");
        int x = Integer.parseInt(parsedCell[0]);
        int y = Integer.parseInt(parsedCell[1]);
        if (x + 2 < maze.length) {
            if (maze[x + 2][y] != null && maze[x + 2][y].equals("WALL")) {
                result.add((x + 2) + " " + y);
            }
        }
        if (y + 2 < maze.length) {
            if (maze[x][y + 2] != null && maze[x][y + 2].equals("WALL")) {
                result.add(x + " " + (y + 2));
            }
        }
        if (x >= 2) {
            if (maze[x - 2][y] != null && maze[x - 2][y].equals("WALL")) {
                result.add((x - 2) + " " + y);
            }
        }
        if (y >= 2) {
            if (maze[x][y - 2] != null && maze[x][y - 2].equals("WALL")) {
                result.add(x + " " + (y - 2));
            }
        }
        return result;
    }

    public static List<String> getPassagesForPrimGenerator(String cell, String[][] maze) {
        List<String> result = new ArrayList<>();
        String[] parsedCell = cell.split(" ");
        int x = Integer.parseInt(parsedCell[0]);
        int y = Integer.parseInt(parsedCell[1]);
        if (x + 2 < maze.length) {
            if (maze[x + 2][y] != null && maze[x + 2][y].equals("PASSAGE")) {
                result.add((x + 2) + " " + y);
            }
        }
        if (y + 2 < maze.length) {
            if (maze[x][y + 2] != null && maze[x][y + 2].equals("PASSAGE")) {
                result.add(x + " " + (y + 2));
            }
        }
        if (x >= 2) {
            if (maze[x - 2][y] != null && maze[x - 2][y].equals("PASSAGE")) {
                result.add((x - 2) + " " + y);
            }
        }
        if (y >= 2) {
            if (maze[x][y - 2] != null && maze[x][y - 2].equals("PASSAGE")) {
                result.add(x + " " + (y - 2));
            }
        }
        return result;
    }

    public static void printMaze(String[][] maze) {
        for (String[] x : maze) {
            StringBuilder result = new StringBuilder();
            for (String y : x) {
                switch (y) {
                    case "PASSAGE" -> result.append(y.replace("PASSAGE", "░░"));
                    case "WALL" -> result.append(y.replace("WALL", "██"));
                    case "DESTROYED_WALL" -> result.append(y.replace("DESTROYED_WALL", "░░"));
                    case "WAY_OUT" -> result.append(y.replace("WAY_OUT", ANSI_BLUE + "░░" + ANSI_RESET));
                }

            }
            System.out.println(result);
        }
    }
}
