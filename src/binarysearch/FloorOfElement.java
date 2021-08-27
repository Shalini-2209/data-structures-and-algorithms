package binarysearch;

public class FloorOfElement {
    public static void main(String[] args) {
        int arr[] = {3, 4, 8, 10, 12, 19};

        int elt = 5;
        int res = -1;
        int start = 0, end = arr.length - 1;

        while(start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == elt) {
                System.out.println("Floor: " + arr[mid]);
                return;
            }
            if(elt > arr[mid]){
                res = Math.max(res, arr[mid]);
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        System.out.println("Floor: " + res);
    }
}