package dp.group1;

import java.util.ArrayList;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int arr[] = {7, 2, 94, 49, 30, 24, 85, 55, 57, 41 };
        int sum = 0;

        for (int val: arr)
            sum += val;

        boolean dp[][] = new boolean[arr.length+1][sum+1];

        int min = findSubsetSumTable(arr, sum, dp, arr.length);

        System.out.println("Minimum subset difference : " + min);

        System.out.println("Minimum subset difference using recursion : " + findSubsetSumRec(arr,  arr.length, 0, 0));

    }

    private static int findSubsetSumRec(int[] arr, int n, int s1, int s2) {
        if(n == 0) return Math.abs(s1 - s2);

        int set1 = findSubsetSumRec(arr, n-1, s1+arr[n-1], s2);
        int set2 = findSubsetSumRec(arr, n-1, s1, s2+arr[n-1]);

        return Math.min(set1, set2);
    }

    private static int findSubsetSumTable(int[] arr, int sum, boolean dp[][], int n ) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];

                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        for (int i = 0; i <= dp[0].length/2; i++)
            if(dp[n][i]) list.add(i);

        //System.out.println(list);

        for (Integer val: list)
            min = Math.min(min, Math.abs(sum - (2 * val)));

        return min;
    }
}
