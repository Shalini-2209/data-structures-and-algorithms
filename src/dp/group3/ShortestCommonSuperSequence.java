package dp.group3;

// Finds the length of shortest common super sequence
public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        // Merge the length - lcs
        System.out.println("Length of the shortest common super sequence: " +  findUsingTable(a, b, a.length(), b.length()));
     }

    private static int findUsingTable(String a, String b, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j]= 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return (m + n) - dp[n][m];
    }
}
