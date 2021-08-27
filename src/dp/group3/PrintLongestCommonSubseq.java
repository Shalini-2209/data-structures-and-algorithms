package dp.group3;

public class PrintLongestCommonSubseq {
    static StringBuilder res;
    public static void main(String[] args) {
        res = new StringBuilder("") ;
        String s1 = "animal";
        String s2 = "mammal";

        System.out.println(findUsingTable(s1, s2, s1.length(), s2.length()));
        findUsingRec(s1, s2, s1.length(), s2.length());
        System.out.println(res.reverse().toString());
    }

    private static int findUsingRec(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0) return 0;

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            res.append(s1.charAt(n-1));
            return 1 + findUsingRec(s1, s2, n-1, m-1);
        }

        else
            return Math.max(findUsingRec(s1, s2, n-1, m), findUsingRec(s1, s2, n, m-1));
    }

    private static String findUsingTable(String s1, String s2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return getSequence(s1, s2, n, m, dp);
    }

    private static String getSequence(String s1, String s2, int n, int m, int[][] dp) {
        // Starting from the last cell
        int i = n, j = m;
        StringBuilder ans = new StringBuilder("");

        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--; j--;
            }

            else{
                if(dp[i][j-1] > dp[i-1][j]) j--;
                else i--;
            }
        }

        return ans.reverse().toString();
    }
}
