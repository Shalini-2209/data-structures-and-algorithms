package dp.group1;

public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3};
        int sum = 1;

        if(arr.length == 1 && arr[0] == sum || arr[0] == -sum) {
            System.out.println("1");
            return;
        }

        if(arr.length == 1 && arr[0] != sum) {
            System.out.println("0");
            return;
        }

        CountNoOfSubsetWithDiff obj = new CountNoOfSubsetWithDiff();

        int s = 0;

        for(int val: arr) s += val;

        if((s + sum )% 2 != 0) {
            System.out.println("No possible subsets ");
            return;
        }

        int s1 = (sum + s)/2;
        System.out.println("Target sum using table: " + obj.findCountUsingTable(arr, s1 ,arr.length));

        System.out.println("Target sum using rec: " + findUsingRec(arr, sum, arr.length));
    }

    private static int findUsingRec(int[] arr, int sum, int n) {
        if(n == 0) {
            if (sum == 0) return 1;
            return 0;
        }

        int plus = findUsingRec(arr, sum + arr[n-1], n-1);
        int minus = findUsingRec(arr, sum - arr[n-1], n-1);

        return plus+minus;
    }
}