package dp.group1;

public class CountNoOfSubsetWithDiff {
    public static void main(String[] args) {
        // Given
        int arr[] = {0,0,0,0,0,0,0,0,1};
        int diff = 1;

//        s1 - s2 = diff  |||^rly s1 + s2 = sum(arr)
//        2s1 = diff + sum(arr)

        int sum = 0;

        for (int val: arr)
            sum += val;

        if((sum + diff) % 2 != 0) {
            System.out.println("No possible subsets ");
            return;
        }

        int s1 = (diff + sum)/2;

        System.out.println("Count of subsets with the given diff using table: " + findCountUsingTable(arr, s1, arr.length));
        System.out.println("Count of subsets with the given diff using recursion: " +findCountUsingRec(arr, s1, arr.length));
    }

    static int findCountUsingRec(int[] arr, int s1, int n) {
        if(n == 0){
            if(s1 == 0) return 1;
            return 0;
        }

        if(arr[n-1] <= s1){
            return findCountUsingRec(arr, s1-arr[n-1], n-1)  + findCountUsingRec(arr, s1, n-1);}
        else
            return findCountUsingRec(arr, s1, n-1);
    }

    static int findCountUsingTable(int[] arr, int s1, int n) {
        int dp[][] = new int[n+1][s1+1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < s1+1; j++) {
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][s1];
    }
}
