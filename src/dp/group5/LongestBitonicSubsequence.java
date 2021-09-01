package dp.group5;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        int res = findLBS(arr, arr.length);
        System.out.println("LBS " + res);

    }

    private static int findLBS(int[] arr, int n) {

        int lis[] = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i] >= arr[j])
                    max = Math.max(lis[j], max);
            }
            lis[i] = max + 1;
        }

        int lds[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n-1; j > i ; j--) {
                if(arr[i] >= arr[j])
                    max = Math.max(lds[j], max);
            }
            lds[i] = max + 1;
        }

        int omax = 0;
        for (int i = 0; i < n; i++) {
            omax = Math.max(omax, lds[i] + lis[i] - 1);
        }

        return omax;

    }
}
