package dp.group1;

public class EqualSumPartition {
    public static void main(String[] args) {
        int arr[] = {1, 5, 5, 11};
        int sum = 0;

        for (int val : arr)
            sum += val;

        if (sum % 2 != 0) {
            System.out.println("Equal sum partitions doesn't exists ");
            return;
        } else {
            if (findSubsetSum(arr, sum / 2, arr.length)) System.out.println("Subset exists");
            else System.out.println("Equal sum partitions doesn't exists ");
        }

    }

    private static boolean findSubsetSum(int[] arr, int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];

                else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }
        return dp[n][sum];
    }
}
