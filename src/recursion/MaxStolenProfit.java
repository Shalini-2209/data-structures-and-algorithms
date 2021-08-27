package recursion;

public class MaxStolenProfit {
    static int max;
    public static void main(String[] args) {
        max = Integer.MIN_VALUE;
        int arr[] = {5, 3, 4, 11, 2};
        findProfit(arr, arr.length, 0);
        int dp[][] = new int[arr.length][1];
        System.out.println(findUsingDP(arr, arr.length));
        System.out.println(max);
    }

    private static int findUsingDP(int[] arr, int n) {
        if(n == 0) return 0;

        int oldinc = arr[0];
        int oldexc = 0;

        for (int i = 1; i < n; i++) {
            int newinc = oldexc + arr[i];
            int newexc = Math.max(oldexc, oldinc);

            oldexc = newexc;
            oldinc = newinc;
        }

        return Math.max(oldexc, oldinc);
    }


    private static void findProfit(int[] arr, int n, int sum) {
        if(n <= 0){
            max = Math.max(max, sum);
            return;
        }

        findProfit(arr, n-2, sum+arr[n-1]);
        findProfit(arr, n-1, sum);
    }
}
