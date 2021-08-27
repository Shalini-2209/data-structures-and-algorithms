package binarysearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {

        ArrayRotatedTimes rotations = new ArrayRotatedTimes();
        BinarySearch bs = new BinarySearch();

        int arr[] = {11, 13, 15, 17, 3, 5, 7,9};
        int elt = 15;

        int min = rotations.countNoOfTimesRotated(arr);

        int val1 = bs.binarySearch(arr, 0, min - 1, elt);
        int val2 = bs.binarySearch(arr, min+1, arr.length-1, elt);

        if(val1 != -1)
            System.out.println(val1);
        else
            System.out.println(val2);

    }
}
