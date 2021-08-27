package binarysearch;

//Number of times array is rotated
public class   ArrayRotatedTimes {

    public static int countNoOfTimesRotated(int arr[]) {
        int min = 0, n = arr.length;
        int start = 0; int end = n - 1;

        while(start <= end){

            int mid = ((end - start)/2) + start;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                min = mid;
                System.out.println(min + " is the minimum element.");
                break;
            }

            if(arr[mid] <= arr[end])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return min;
    }


    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 3, 4};

        System.out.println(countNoOfTimesRotated(arr));
    }
}
