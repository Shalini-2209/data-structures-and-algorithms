package binarysearch;

public class FirstOneInBinary {
    // Index of first one in infinite binary sorted array
    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1};

        int k = 1;
        int first = -1;

        int start = 0;
        int end = 1;

        while(arr[end] < k){
            start = end;
            end = end * 2;
        }

        while(start <= end){
            int mid = start + ((end - start)/2);

            if(arr[mid] == k){
                first = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        System.out.println("First elt");
        System.out.println(first);
    }
}
