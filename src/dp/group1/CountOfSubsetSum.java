package dp.group1;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        // count the no of subsets equals to the given sum
        int arr[] = {2, 1, 4, 5, 8, 10};
        int sum = 10;

        int dp[][] = new int[arr.length+1][sum+1];
        System.out.println(findCountRec(arr, sum, arr.length));
        System.out.println(findCountMem(arr, sum, arr.length,dp));
        System.out.println(findCountTable(arr, sum, arr.length));
    }

    private static int findCountTable(int[] arr, int sum, int n) {
        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    private static int findCountMem(int[] arr, int sum, int n, int dp[][]) {
        if(n == 0) {
            if (sum == 0) return 1;
            return 0;
        }

        if(dp[n][sum] > 0) return dp[n][sum];

        if(arr[n-1] <= sum)
            dp[n][sum] =  findCountMem(arr, sum - arr[n-1], n-1, dp) + findCountMem(arr, sum, n-1, dp);
        else
            dp[n][sum] = findCountMem(arr, sum, n-1, dp);

        return dp[n][sum];
    }

    private static int findCountRec(int[] arr, int sum, int n) {
        if(n == 0) {
            if (sum == 0) return 1;
            return 0;
        }

        if(arr[n-1] <= sum)
            return findCountRec(arr, sum - arr[n-1], n-1) + findCountRec(arr, sum, n-1);
        else return findCountRec(arr, sum, n-1);
    }
}
