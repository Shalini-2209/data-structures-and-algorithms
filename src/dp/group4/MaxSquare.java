package dp.group4;

public class MaxSquare {
    public static void main(String[] args) {
        int mat[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        int size = findMaxSquareUsingTable(mat);
        System.out.println("Size of max square: " + size);
    }

    private static int findMaxSquareUsingTable(int[][] mat) {
        int dp[][] = new int[mat.length][mat[0].length];
        int size = 0;
        int min = Integer.MAX_VALUE;

        for (int i = mat.length - 1; i >= 0 ; i--) {
            for (int j = mat[0].length - 1; j >= 0 ; j--) {
                if(i == mat.length - 1 && j ==  mat[0].length - 1)
                    dp[i][j] = mat[i][j];
                else if(i == mat.length - 1)
                    dp[i][j] = mat[i][j];
                else if(j ==  mat[0].length - 1)
                    dp[i][j] = mat[i][j];
                else{
                    if(mat[i][j] == 0)
                        dp[i][j] = 0;
                    else{
                        // Finds the min out of right cell, bottom cell and the diagonal cell
                        min = Math.min(dp[i][j+1], dp[i+1][j]);
                        min = Math.min(min, dp[i+1][j+1]);
                        dp[i][j] = min + 1;
                    }
                }
                size = Math.max(size, dp[i][j]);
            }
        }
        return size;
    }
}
