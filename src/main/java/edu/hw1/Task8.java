package edu.hw1;

@SuppressWarnings("MagicNumber")
public class Task8 {

    private Task8() {

    }

    public static boolean knightBoardCapture(int[][] board) {
        int counter = -1;
        for (int[] i : board) {
            counter++;
            for (int j : i) {
                if (j == 1) {
                    if (!(xGreaterYGreater(counter, j, board)
                        && xSmallerYSmaller(counter, j, board)
                        && xGreaterYSmaller(counter, j, board)
                        && xSmallerYGreater(counter, j, board))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean xGreaterYGreater(int x, int y, int[][] board) {
        int x1 = x + 2;
        int y1 = y + 1;
        int x2 = x + 1;
        int y2 = y + 2;
        if ((x1 <= 7) && (y1 <= 7)) {
            if ((board[x1][y1] == 1)) {
                return false;
            }
        }
        if ((x2 <= 7) && (y2 <= 7)) {
            return board[x2][y2] != 1;
        }
        return true;
    }

    public static boolean xSmallerYSmaller(int x, int y, int[][] board) {
        int x1 = x - 2;
        int y1 = y - 1;
        int x2 = x - 1;
        int y2 = y - 2;
        if ((0 <= x1) && (0 <= y1)) {
            if ((board[x1][y1] == 1)) {
                return false;
            }
        }
        if ((0 <= x2) && (0 <= y2)) {
            return board[x2][y2] != 1;
        }
        return true;
    }

    public static boolean xGreaterYSmaller(int x, int y, int[][] board) {
        int x1 = x + 2;
        int y1 = y - 1;
        int x2 = x + 1;
        int y2 = y - 2;
        if ((x1 <= 7) && (0 <= y1)) {
            if ((board[x1][y1] == 1)) {
                return false;
            }
        }
        if ((x2 <= 7) && (0 <= y2)) {
            return board[x2][y2] != 1;
        }
        return true;
    }

    public static boolean xSmallerYGreater(int x, int y, int[][] board) {
        int x1 = x - 2;
        int y1 = y + 1;
        int x2 = x - 1;
        int y2 = y + 2;
        if ((0 <= x1) && (y1 <= 7)) {
            if ((board[x1][y1] == 1)) {
                return false;
            }
        }
        if ((0 <= x2) && (y2 <= 7)) {
            return board[x2][y2] != 1;
        }
        return true;
    }
}
