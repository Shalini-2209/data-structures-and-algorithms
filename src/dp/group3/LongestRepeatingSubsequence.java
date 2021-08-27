package dp.group3;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String a = "aabebcdd";
        System.out.println("Length of Longest Repeating Subsequence " + findLRS(a, a, a.length()));
    }

    private static int findLRS(String a, String b, int n) {
        int dp[][] = new int[n+1][n+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(a.charAt(i-1) == b.charAt(j-1) && i != j)
                    dp[i][j]= 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[n][n];
    }
}
