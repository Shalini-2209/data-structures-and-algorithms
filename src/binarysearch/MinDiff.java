package binarysearch;

public class MinDiff {
    // Min diff of an element in a sorted element

    public static void main(String[] args) {
        int arr[] = {1, 2, 13, 15, 17, 29, 31, 40};
        int start = 0;
        int end = arr.length - 1;
        int key = 8;

        while (start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == key) {
                System.out.println("0");
                return;
            }
            if(arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }

        int res = Math.min(Math.abs(key-arr[start]),Math.abs(arr[end]-key));
        System.out.println(res);

}}

