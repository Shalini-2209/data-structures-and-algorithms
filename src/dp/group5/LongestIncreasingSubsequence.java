package dp.group5;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int res = findLIS(arr, arr.length);
        System.out.println("LIS " + res);
    }

    private static int findLIS(int[] arr, int n) {
        int dp[] = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
