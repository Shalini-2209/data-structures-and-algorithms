package binarysearch;

public class SearchInTwoDimensionalArray {
    public static void main(String[] args) {
        int elt = 29;
        int arr[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        findPosition(arr, elt);
    }

    private static void findPosition(int[][] arr, int elt) {
        int i = 0;
        int j = arr.length - 1;

        while(i >= 0 && j < arr.length){
            if(arr[i][j] == elt){
                System.out.println("Element found at row " + i + " column " + j);
                return;
            }
            else if(arr[i][j] > elt) j--;
            else i++;
        }
        System.out.println("Not found");
    }
}
