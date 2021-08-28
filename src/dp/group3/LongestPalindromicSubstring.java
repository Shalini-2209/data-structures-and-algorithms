package dp.group3;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String a = "Geeks";
        StringBuilder rev = new StringBuilder(a);
        System.out.println(findLCS(a, rev.reverse().toString(), a.length(), a.length()));
    }

    private static int findLCS(String a, String b, int n, int m) {
        int dp[][] = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(b.charAt(j-1) == a.charAt(i-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
