package dp.group2;

public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int sum = 5;
        int dp[][] = new int[coins.length+1][sum+1];

        System.out.println("No of ways to get the sum using Recursion " + findNoOfWaysUsingRec(coins, sum, coins.length));
        System.out.println("No of ways to get the sum using Table " + findNoOfWaysUsingTable(coins, sum, coins.length));
        System.out.println("No of ways to get the sum using Memoization " + findNoOfWaysUsingMem(coins, sum, coins.length, dp));
    }

    private static int findNoOfWaysUsingMem(int[] coins, int sum, int n, int[][] dp) {

        if(n == 0){
            if (sum == 0)
                return 1;
            return 0;
        }
        else if(sum < 0) return 0;

        if(dp[n][sum] != 0) return dp[n][sum];
        int chosen = 0;

        if(coins[n-1] <= sum)
            chosen = findNoOfWaysUsingRec(coins, sum - coins[n - 1], n);

        return dp[n][sum] = chosen + findNoOfWaysUsingRec(coins,sum, n-1);
    }

    private static int findNoOfWaysUsingTable(int[] coins, int sum, int n) {
        int dp[][] = new int[n+1][sum+1];

        for (int i=0; i<n; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(coins[i-1] <= j)
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];

                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    private static int findNoOfWaysUsingRec(int[] coins, int sum, int n) {
        if(n == 0){
            if (sum == 0)
                return 1;
            return 0;
        }
        else if(sum < 0) return 0;
        int chosen = 0;

        if(coins[n-1] <= sum)
            chosen = findNoOfWaysUsingRec(coins, sum - coins[n - 1], n);

        return chosen + findNoOfWaysUsingRec(coins,sum, n-1);
    }
}