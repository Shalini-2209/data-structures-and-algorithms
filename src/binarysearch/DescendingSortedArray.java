package binarysearch;

public class DescendingSortedArray {
    public static void main(String[] args) {
        //descending order
        int arr[] = {20, 15, 10, 5, 1, 0};

        int start = 0;
        int end = arr.length - 1;
        int elt = 15;

        while(start<=end){

            int mid = start + ((end - start)/2);

            if(elt == arr[mid]){
                System.out.println(mid);
                return;
            }
            if(arr[mid] > elt)
                start = mid + 1;
            else
                end = mid - 1;

        }
    }
}
