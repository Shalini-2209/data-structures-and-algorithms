package binarysearch;

public class PeakElement {

    public static int peakElement(int[] arr, int n) {
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            System.out.println("Mid " + mid + " : End " + end + " " + start);

            if (mid > 0 && mid < n-1) {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                    return mid;
                else if (arr[mid] < arr[mid + 1])
                    start = mid + 1;
                else 
                    end = mid - 1;
            }

            else if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == n - 1) {
                if (arr[mid] < arr[mid - 1])
                    return n - 2;
                 else
                    return n - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {12, 13, 4, 7, 10, 10, 6, 2, 8, 14, 3, 13};
        int n = 12;
        int ans = peakElement(arr, n);
        System.out.println(ans);
    }
}
