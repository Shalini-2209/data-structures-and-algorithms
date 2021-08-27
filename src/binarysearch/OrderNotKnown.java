package binarysearch;

public class OrderNotKnown {
    public static void main(String[] args) {
        int arr[] = {20, 15, 10, 5, 1, 0};
        int elt = 10;

        boolean ascending = false;
        int start = 0, end = arr.length -1;

        if(arr[0] < arr[1]) ascending = true;

        while(start <= end){
            int mid = start + ((end - start)/2);

            if(elt == arr[mid]){
                System.out.println(mid);
                return;
            }

            if(ascending && arr[mid] > elt)
                end = mid - 1;
            else
                start = mid + 1;

            if(ascending && arr[mid] < elt)
                start = mid + 1;
            else
                end = mid - 1;

        }
    }
}
