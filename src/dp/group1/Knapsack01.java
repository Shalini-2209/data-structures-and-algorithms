package dp.group1;

public class Knapsack01 {
    public static void main(String[] args) {
        int wt[] = {1, 1, 1};
        int val[] = {10, 20, 30};

        // n => No of things capacity => bag's capacity
        int n = 3, capacity = 2;
        int dp[][] = new int[n+1][capacity+1];
        System.out.println("Maximum Profit using recursion : " + findUsingRec(wt, val, n, capacity));
        System.out.println("Maximum Profit using memoization : " + findUsingMem(wt, val, n, capacity, dp));
        System.out.println("Max Profit using top down approach : " + findUsingTable(wt, val, n, capacity));
    }

    private static int findUsingTable(int[] wt, int[] val, int n, int capacity) {
        int dp[][] = new int[n+1][capacity+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
               if(wt[i-1] <= j){
                   int chosen = val[i-1] + dp[i-1][j - wt[i-1]];
                   int notChosen = dp[i-1][j];
                   dp[i][j] = Math.max(chosen, notChosen);
               }

               else if(wt[i-1] > j)
                   dp[i][j] = dp[i-1][j];

            }
        }

        return dp[n][capacity];

    }

    private static int findUsingMem(int[] wt, int[] val, int n, int capacity, int[][] dp) {

        if(n == 0 || capacity == 0) return 0;

        else if(dp[n][capacity] != 0) return dp[n][capacity];

        if(wt[n-1] <= capacity) {
            int chosen = val[n-1] + findUsingMem(wt, val, n-1, capacity - wt[n-1], dp);
            int notChosen = findUsingMem(wt, val, n-1, capacity, dp);
            return dp[n][capacity] = Math.max(chosen, notChosen);
        }

        else if (wt[n-1] > capacity)
            return dp[n][capacity] = findUsingMem(wt, val, n-1, capacity, dp);

        return -1;
    }


    private static int findUsingRec(int[] wt, int[] val, int n, int capacity) {
        if(n == 0 || capacity == 0)
            return 0;

        if(wt[n-1] <= capacity)
            return Math.max(val[n-1] + findUsingRec(wt, val, n-1, capacity - wt[n-1]),
                    findUsingRec(wt, val, n-1, capacity));

        else if(wt[n-1] > capacity)
            return findUsingRec(wt, val, n-1, capacity);

        return -1;
    }
}