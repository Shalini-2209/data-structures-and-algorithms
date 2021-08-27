package dp.group3;

public class MinDeletionToMakeAsAPalindrome {
    // Same for min insertion to make a string as a palindrome
    public static void main(String[] args) {
        String a = "agbcba";
        StringBuilder rev = new StringBuilder(a);
        System.out.println(a.length() -  findLCS(a, rev.reverse().toString(), a.length(), a.length()));
    }

    private static int findLCS(String a, String b, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
