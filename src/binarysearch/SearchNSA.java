package binarysearch;

import javafx.application.Application;
import javafx.stage.Stage;

public class SearchNSA  {
    // Searching in nearly sorted array

    public static void main(String[] args) {
        int arr[] = { 5, 10, 30, 20, 40};

        int elt = 10;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == elt) {
                System.out.println(mid + " is the index.");
                return;
            }
            else if((mid + 1 <= end) && arr[mid + 1] == elt){
                System.out.println(mid + 1 + " is the index");
                return ;
            }
            else if((mid - 1 >= start) && arr[mid - 1] == elt){
                System.out.println((mid - 1)+ " is the index");
                return;
            }

            if(arr[mid] > elt)
                end = mid - 2;
            else
                start = mid + 2;
        }
    }
}
