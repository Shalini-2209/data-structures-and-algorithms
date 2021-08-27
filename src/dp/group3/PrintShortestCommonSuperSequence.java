package dp.group3;

public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "abac";
        String b = "cab";
        // Merge the length - lcs
        System.out.println("Shortest common super sequence: " +  findUsingTable(a, b, a.length(), b.length()));
    }

    private static String findUsingTable(String a, String b, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 1; i < a.length()+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return getString(a, b, n, m, dp);
    }

    private static String getString(String a, String b, int n, int m, int[][] dp) {

        int i = n, j = m;
        StringBuilder ans = new StringBuilder("");

        while (i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans.append(a.charAt(i-1));
                i--; j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    ans.append(a.charAt(i-1));
                    i--;
                }
                else {
                    ans.append(b.charAt(j-1));
                    j--;
                }
            }
        }

        while (i > 0){
            ans.append(a.charAt(i-1));
            i--;
        }

        while(j > 0){
            ans.append(b.charAt(j-1));
            j--;
        }

        return ans.reverse().toString();
    }
}
