package dp.group1;

public class SubsetSum {

    public static void main(String[] args) {

        int arr[] = {2, 3, 7, 8, 10};
        int sum = 11;

        boolean dp[][] = new boolean[arr.length+1][sum+1];

        System.out.println("Subset that makes up sum : " + findUsingRec(arr, sum, arr.length));

        System.out.println("Subset that makes up sum : " + findUsingMem(arr, sum, arr.length,dp));

        System.out.println("Subset that makes up sum : " + findUsingTable(arr, sum, arr.length));
    }

    private static boolean findUsingMem(int[] arr, int sum, int n, boolean[][] dp) {
        if(n == 0){
            if(sum == 0) return true;
            return false;
        }

        if(dp[n][sum]) return dp[n][sum];

        if(arr[n-1] <= sum)
               dp[n][sum] = findUsingMem(arr, sum-arr[n-1], n-1, dp) || findUsingMem(arr, sum, n-1, dp);


        else dp[n][sum] = findUsingMem(arr, sum, n-1, dp);

        return dp[n][sum];
    }

    private static boolean findUsingRec(int[] arr, int sum, int n) {
       if(n == 0) {
           if(sum == 0) return true;
           return false;
       }

       if(arr[n-1] <= sum)
           return findUsingRec(arr, sum-arr[n-1], n-1) || findUsingRec(arr, sum, n-1);
       else
           return findUsingRec(arr, sum, n-1);
    }

    private static boolean findUsingTable(int[] arr, int sum, int n) {
        boolean dp[][] = new boolean[n+1][sum+1];

        for (int i = 0; i < n+1; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];

                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
