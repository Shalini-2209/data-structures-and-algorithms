package binarysearch;
import java.io.*;
import java.util.*;

public class BinarySearch {

        public static int binarySearch(int arr[], int start, int end, int elt){
            while(start <= end){
                int mid = start + ((end - start) / 2);

                if(elt == arr[mid]) {System.out.println(mid);
                    return mid;}

                if(arr[mid] > elt )
                    end = mid - 1;

                else
                    start = mid + 1;
            }

            return -1;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter n");
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println("enter elt to be searched");
            int elt = sc.nextInt();
            int start = 0; int end = n - 1;
            binarySearch(arr, start, end, elt);

            System.out.println("-1");
        }
    }

