package binarysearch;

public class CeilOfElement {
    public static void main(String[] args) {
        int arr[] = {3, 4, 8, 10, 12, 19};

        int elt = 5;

        int start = 0, end = arr.length - 1;
        int res = 0;

        while(start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == elt) {
                System.out.println(arr[mid]);
                return;
            }
            if(arr[mid] > elt){
                res = arr[mid];
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        System.out.println(res);
    }
}
