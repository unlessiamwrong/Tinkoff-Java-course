package edu.project2;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"MultipleStringLiterals", "MagicNumber", "RegexpSinglelineJava", "MissingSwitchDefault",
    "CyclomaticComplexity"})
public class Utility {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private Utility() {

    }

    public static void removeWall(Cell current, Cell neighbor, String[][] maze) {

        int subtractionX = current.x - neighbor.x;
        int subtractionY = current.y - neighbor.y;

        if (subtractionX == 0) {
            if (subtractionY < 0) {
                maze[current.x][current.y + 1] = "DESTROYED_WALL";
            } else {
                maze[current.x][current.y - 1] = "DESTROYED_WALL";
            }

        }
        if (subtractionY == 0) {
            if (subtractionX < 0) {
                maze[current.x + 1][current.y] = "DESTROYED_WALL";
            } else {
                maze[current.x - 1][current.y] = "DESTROYED_WALL";
            }
        }
    }

    public static void computeWay(Cell current, Cell neighbor, String[][] maze) {
        int subtractionX = current.x - neighbor.x;
        int subtractionY = current.y - neighbor.y;
        maze[neighbor.x][neighbor.y] = "PASSAGE";

        if (subtractionX == 0) {
            if (subtractionY < 0) {
                maze[current.x][current.y + 1] = "PASSAGE";
            } else {
                maze[current.x][current.y - 1] = "PASSAGE";
            }

        }
        if (subtractionY == 0) {
            if (subtractionX < 0) {
                maze[current.x + 1][current.y] = "PASSAGE";
            } else {
                maze[current.x - 1][current.y] = "PASSAGE";
            }
        }
    }

    public static ArrayList<Cell> getNeighborsDFSGenerator(int x, int y, List<Cell> unvisited) {
        ArrayList<Cell> randomPickList = new ArrayList<>();

        if (unvisited.stream().anyMatch(cell -> cell.x == x + 2 && cell.y == y)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x + 2 && cell.y == y).findAny().get());
        }

        if (unvisited.stream().anyMatch(cell -> cell.x == x && cell.y == y + 2)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x && cell.y == y + 2).findAny().get());
        }

        if (unvisited.stream().anyMatch(cell -> cell.x == x - 2 && cell.y == y)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x - 2 && cell.y == y).findAny().get());
        }

        if (unvisited.stream().anyMatch(cell -> cell.x == x && cell.y == y - 2)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x && cell.y == y - 2).findAny().get());
        }
        return randomPickList;
    }

    public static ArrayList<Cell> getNeighborsDFSSolver(int x, int y, List<Cell> unvisited) {
        ArrayList<Cell> randomPickList = new ArrayList<>();

        if (unvisited.stream().anyMatch(cell -> cell.x == x + 1 && cell.y == y)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x + 1 && cell.y == y).findAny().get());
        }

        if (unvisited.stream().anyMatch(cell -> cell.x == x && cell.y == y + 1)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x && cell.y == y + 1).findAny().get());
        }

        if (unvisited.stream().anyMatch(cell -> cell.x == x - 1 && cell.y == y)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x - 1 && cell.y == y).findAny().get());
        }

        if (unvisited.stream().anyMatch(cell -> cell.x == x && cell.y == y - 1)) {
            randomPickList.add(unvisited.stream().filter(cell -> cell.x == x && cell.y == y - 1).findAny().get());
        }
        return randomPickList;
    }

    public static ArrayList<Cell> getNeighborsBFSSolver(int x, int y, Cell[][] path, String[][] maze) {
        ArrayList<Cell> randomPickList = new ArrayList<>();

        if (x + 2 < path.length
            && path[x + 1][y] == null
            && (maze[x + 1][y].equals("PASSAGE") || maze[x + 1][y].equals("DESTROYED_WALL"))) {
            randomPickList.add(new Cell(x + 1, y));
        }

        if (y + 2 < path.length
            && path[x][y + 1] == null
            && (maze[x][y + 1].equals("PASSAGE") || maze[x][y + 1].equals("DESTROYED_WALL"))) {
            randomPickList.add(new Cell(x, y + 1));
        }

        if (x >= 2
            && path[x - 1][y] == null
            && (maze[x - 1][y].equals("PASSAGE") || maze[x - 1][y].equals("DESTROYED_WALL"))) {
            randomPickList.add(new Cell(x - 1, y));
        }

        if (y >= 2
            && path[x][y - 1] == null
            && (maze[x][y - 1].equals("PASSAGE") || maze[x][y - 1].equals("DESTROYED_WALL"))) {
            randomPickList.add(new Cell(x, y - 1));
        }
        return randomPickList;
    }

    public static List<Cell> getWallsPrimGenerator(Cell cell, String[][] maze) {
        List<Cell> result = new ArrayList<>();

        if (cell.x + 2 < maze.length) {
            if (maze[cell.x + 2][cell.y] != null && maze[cell.x + 2][cell.y].equals("WALL")) {
                result.add(new Cell(cell.x + 2, cell.y));
            }
        }
        if (cell.y + 2 < maze.length) {
            if (maze[cell.x][cell.y + 2] != null && maze[cell.x][cell.y + 2].equals("WALL")) {
                result.add(new Cell(cell.x, cell.y + 2));
            }
        }
        if (cell.x >= 2) {
            if (maze[cell.x - 2][cell.y] != null && maze[cell.x - 2][cell.y].equals("WALL")) {
                result.add(new Cell(cell.x - 2, cell.y));
            }
        }
        if (cell.y >= 2) {
            if (maze[cell.x][cell.y - 2] != null && maze[cell.x][cell.y - 2].equals("WALL")) {
                result.add(new Cell(cell.x, cell.y - 2));
            }
        }
        return result;
    }

    public static List<Cell> getPassagesPrimGenerator(Cell cell, String[][] maze) {
        List<Cell> result = new ArrayList<>();

        if (cell.x + 2 < maze.length) {
            if (maze[cell.x + 2][cell.y] != null && maze[cell.x + 2][cell.y].equals("PASSAGE")) {
                result.add(new Cell(cell.x + 2, cell.y));
            }
        }
        if (cell.y + 2 < maze.length) {
            if (maze[cell.x][cell.y + 2] != null && maze[cell.x][cell.y + 2].equals("PASSAGE")) {
                result.add(new Cell(cell.x, cell.y + 2));
            }
        }
        if (cell.x >= 2) {
            if (maze[cell.x - 2][cell.y] != null && maze[cell.x - 2][cell.y].equals("PASSAGE")) {
                result.add(new Cell(cell.x - 2, cell.y));
            }
        }
        if (cell.y >= 2) {
            if (maze[cell.x][cell.y - 2] != null && maze[cell.x][cell.y - 2].equals("PASSAGE")) {
                result.add(new Cell(cell.x, cell.y - 2));
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

    //create field with passages surrounded by walls
    public static String[][] setFieldDFSGenerator(int width, int height, List<Cell> unvisited) {
        String[][] maze = new String[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    maze[i][j] = "PASSAGE";
                    unvisited.add(new Cell(i, j));
                } else {
                    maze[i][j] = "WALL";
                }
            }
        }
        return maze;
    }

    //create field full of walls
    public static String[][] sefFieldPrimGenerator(int width, int height) {
        String[][] maze = new String[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = "WALL";
            }
        }
        return maze;
    }

    public static void markPassagesDFSSolver(String[][] maze, int sideLength, List<Cell> unvisited) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (maze[i][j].equals("PASSAGE") || maze[i][j].equals("DESTROYED_WALL")) {
                    unvisited.add(new Cell(i, j));
                }
            }
        }
    }

}
