package dp.group3;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "animal";
        String s2 = "mammal";
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(findUsingMem(s1, s2, s1.length(), s2.length(), dp));
        System.out.println(findUsingRec(s1, s2, s1.length(), s2.length()));
        System.out.println(findUsingTable(s1, s2, s1.length(), s2.length()));
    }

    private static int findUsingTable(String s1, String s2, int n, int m) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[n][m];
    }

    private static int findUsingMem(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0)  return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1))
            return dp[n][m]  = 1 + findUsingRec(s1, s2, n-1, m-1);
        else
            return dp[n][m] =  Math.max(findUsingRec(s1, s2, n, m-1) , findUsingRec(s1, s2, n-1, m));
    }


    private static int findUsingRec(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) return 0;

        if(s1.charAt(n-1) == s2.charAt(m-1))
            return 1 + findUsingRec(s1, s2, n-1, m-1);
        else
            return Math.max(findUsingRec(s1, s2, n, m-1) , findUsingRec(s1, s2, n-1, m));
    }
}