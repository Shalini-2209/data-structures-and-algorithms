package backtracking;

public class NQueens {
    public static void main(String[] args) {
        int m[][] ={ { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        int initialRow = 0;
        printQueens(m, "", initialRow);
    }

    private static void printQueens(int[][] m, String s, int row) {
        if(row == m.length){
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(s);
            return;
        }

        for (int col = 0; col < m.length; col++) {
            if(isSafe(m, row, col)) {
                m[row][col] = 1;
                printQueens(m, s + row + "-" + col + ",", row + 1);
                m[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] m, int row, int col) {
        // checks upwards
        for (int i = row - 1 , j = col; i >= 0 ; i--) {
            if(m[i][j] == 1) return false;
        }
        // left diagonal
        for (int i = row - 1, j = col-1; i >=0 && j>=0 ; i-- , j--) {
            if(m[i][j] == 1) return false;
        }
        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0  && j <m.length; i--, j++) {
            if(m[i][j] == 1) return false;
        }
        return true;
    }
}