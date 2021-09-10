package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 8, 5, 7, 4};
        int n = arr.length;
        bubbleSort(arr, n);

        for (int i: arr) {
            System.out.println(i);
        }
    }

    private static void bubbleSort(int[] arr, int n) {
        boolean swapped ;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j+1] < arr[j]){
                    swapped = true;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(!swapped) break;
        }
    }
}
