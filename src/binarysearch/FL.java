package binarysearch;

import java.util.ArrayList;

public class FL {
// Finding the first and last occurrence of a given number
        private static int findFirst(int arr[],int n,int x){
          int end = n - 1;
          int start = 0;
          int first = -1;

          while(start <= end){
              int mid = start + ((end - start)/2);
              if(arr[mid] == x){
                  first = mid;
                  end = mid - 1;
              }

              if(arr[mid] > x) end = mid - 1;
              else start = mid + 1;
          }
          return first;
        }

        private static int findLast(int arr[],int n,int x){
          int last = -1;
          int start = 0;
          int end = n - 1;

          while(start <= end){
              int mid = start + ((end - start)/2);
              if(arr[mid] == x){
                  last = mid;
                  start = mid + 1;
              }
              if(arr[mid] > x) end = mid - 1;
              else start = mid + 1;
          }
          return last;
        }

        public static void find(int arr[], int n, int x)
        {

            ArrayList<Integer> list = new ArrayList<>();

            int first = findFirst(arr, n, x);
            int last = findLast(arr, n, x);
            System.out.println(first);
            list.add(first);
            list.add(last);

            System.out.println("Count " +( last - first + 1) );

            System.out.println(list);

        }

    public static void main(String[] args) {
            int[] arr = {1, 3, 5, 5, 5, 5};
            find(arr, arr.length, 5);
    }
    }

