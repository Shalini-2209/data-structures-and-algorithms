package dp.group3;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String str1 = "axy";
        String str2 = "adxcpy";

        System.out.println(isMatching(str1, str2, str1.length(), str2.length()));
    }

    private static boolean isMatching(String a, String b, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j]= 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        if(dp[n][m] == n) return true;
        return false;
    }
}
