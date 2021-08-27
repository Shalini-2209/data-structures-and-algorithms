package backtracking;

import java.util.ArrayList;

public class FloodFill {
    public static void main(String[] args) {
        int n = 4;
        // Zeroes are the blockages
        int mat[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        
        findPath(mat, n);
    }

    private static void findPath(int[][] mat, int n) {
        boolean vis[][] = new boolean[n][n];
        ArrayList<String> list = new ArrayList<>();

        if(mat[0][0] == 1 || mat[n-1][n-1] == 1)
            dfs(0, 0, mat, n, vis, list, "");

        System.out.println(list);
    }

    private static void dfs(int row, int col, int[][] mat, int n, boolean[][] vis, ArrayList<String> list, String s) {

        if(row < 0 || row > n-1 || col < 0 || col > n-1)
            return;

        if(mat[row][col] == 0 || vis[row][col])
            return;

        if(row == n-1 && col == n-1){
            list.add(s);
            return;
        }
        vis[row][col] = true;
        dfs(row-1, col, mat, n, vis, list, s+"U");
        dfs(row+1, col, mat, n, vis, list, s+"D");
        dfs(row, col-1, mat, n, vis, list, s+"L");
        dfs(row, col+1, mat, n, vis, list, s+"R");
        vis[row][col] = false;

    }
}
