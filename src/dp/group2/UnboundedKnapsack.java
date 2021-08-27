package dp.group2;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int wt[] = {1, 1, 1};
        int val[] = {10, 20, 30};

        // n => No of things capacity => bag's capacity
        int n = 3, capacity = 2;
        int dp[][] = new int[n+1][capacity+1];
        System.out.println("Maximum Profit using recursion : " + findUsingRec(wt, val, n, capacity));
        System.out.println("Max Profit using top down approach : " + findUsingTable(wt, val, n, capacity));
    }

    private static int findUsingRec(int[] wt, int[] val, int n, int capacity) {

        if(n == 0 || capacity == 0) return 0;

        if(wt[n-1] <= capacity)
            return Math.max(val[n-1] + findUsingRec(wt, val, n, capacity - wt[n-1]), findUsingRec(wt, val, n-1, capacity));
        else
            return findUsingRec(wt, val, n-1, capacity);
    }

    private static int findUsingTable(int[] wt, int[] val, int n, int capacity) {
        int dp[][] = new int[n+1][capacity+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if(wt[i-1] <= j){
                    int chosen = val[i-1] + dp[i][j - wt[i-1]];
                    int notChosen = dp[i-1][j];
                    dp[i][j] = Math.max(chosen, notChosen);
                }

                else if(wt[i-1] > j)
                    dp[i][j] = dp[i-1][j];

            }
        }
        return dp[n][capacity];
    }
}
