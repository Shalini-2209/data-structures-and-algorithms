package dp.group5;

public class MaxSumOfLIS {
    public static void main(String[] args) {
        int arr[] =  {1, 101, 2, 3, 100, 4, 5};
        int res = findMaxSumOfLIS(arr, arr.length);
        System.out.println("Max sum  " + res);
    }

    private static int findMaxSumOfLIS(int[] arr, int n) {
        int dp[] = new int[n];
        int omax = Integer.MIN_VALUE; // overall max

        for (int i = 0; i < n; i++) {
            Integer max = null;
            for (int j = 0; j < i; j++) {
                // If cur elt is greater, then update the max sum via dp arr
                if(arr[j] <= arr[i]){
                    if(max == null) max = dp[j];
                    else max = Math.max(max, dp[j]);
                }
            }
            if(max == null) dp[i] = arr[i];
            else dp[i] = max + arr[i];

            omax = Math.max(dp[i], omax);
        }

        return omax;
    }
}