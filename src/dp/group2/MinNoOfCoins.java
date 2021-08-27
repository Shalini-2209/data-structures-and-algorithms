package dp.group2;

public class MinNoOfCoins {
    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int sum = 5;
        int dp[][] = new int[coins.length+1][sum+1];

        System.out.println(findUsingRec(coins, sum , coins.length));
        System.out.println(findUsingMem(coins,sum, coins.length, dp));
        System.out.println(findUsingTable(coins, sum, coins.length));
    }

    private static int findUsingTable(int[] coins, int sum, int n) {
        int dp[][] = new int[coins.length+1][sum+1];

        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = Integer.MAX_VALUE-1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]],  dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];

    }

    private static int findUsingMem(int[] coins, int sum, int n,int dp[][]) {
        if(sum == 0) return 0;
        if (sum < 0) return Integer.MAX_VALUE;

        int res = Integer.MAX_VALUE;

        if(dp[n][sum]!= 0) return dp[n][sum];

        for (int i = 0; i < n; i++) {
            if(coins[i] <= sum) {
                res = Math.min(findUsingMem(coins, sum - coins[i], n, dp) + 1, res);
                dp[n][sum] = res;
            }
        }
        return dp[n][sum];
    }

    private static int findUsingRec(int[] coins, int sum, int n) {
        if(sum == 0) return 0;
        if(sum < 0) return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(coins[i] <= sum)
                res = Math.min(1 + findUsingRec(coins, sum - coins[i], n), res);
        }

        return res;
    }
}
