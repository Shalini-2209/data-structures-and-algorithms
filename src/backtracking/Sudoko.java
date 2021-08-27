package backtracking;

public class Sudoko {
    public static void main(String[] args) {
        int[][] board = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        if(solve(0, 0, board))
            printBoard(board);

    }

    private static boolean solve(int row, int col, int[][] board) {

        if(row == board.length) {
            return true;
        }
//        if(col >= board.length){
//            row += 1;
//            col = 0;
//        }

        int nr = 0;
        int nc = 0;
        if (col == board.length - 1) {
            nr = row + 1;
            nc = 0;
        } else {
            nr = row;
            nc = col + 1;
        }

        if(board[row][col] != 0) return solve(nr, nc, board);

        for (int num = 1; num <= 9; num++) {
            if(isAllowed(board, row, col, num)) {
                    board[row][col] = num;
                    if (solve(nr, nc, board)) return true;
                    board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isAllowed(int[][] board, int row, int col, int num) {
        // Checks row
        for (int i = row, j = 0; j < board.length; j++) {
            if(board[i][j] == num) return false;
        }
        // Checks col
        for (int i = 0, j = col ; i < board.length; i++) {
            if(board[i][j] == num) return false;
        }

        // Checks sub-grid
        int boxRowStart = row / 3 * 3;
        int boxColStart = col / 3 * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
