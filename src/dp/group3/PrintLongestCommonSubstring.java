package dp.group3;

public class PrintLongestCommonSubstring {
    public static void main(String[] args) {

        String s1 = "animal";
        String s2 = "mammal";

        System.out.println(findUsingTable(s1, s2, s1.length(), s2.length()));
        //findUsingRec(s1, s2, s1.length(), s2.length());
        //System.out.println(res.reverse().toString());
    }

    private static String findUsingTable(String s1, String s2, int n, int m) {
        int dp[][]= new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return getSubstring(s1, s2, n, m, dp);
    }

    private static String getSubstring(String s1, String s2, int n, int m, int[][] dp) {
        int i=n, j = m;
        StringBuilder ans = new StringBuilder("");

        while(i > 0 && j> 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--; j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }

        return ans.reverse().toString();
    }
}
