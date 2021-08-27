package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
    static int count;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        count = 0;
        // 2, 4, 6 ,8, 10, 12, 14, 16
        int arr[] = {12, 10, 8, 8, 12, 10, 15, 6, 5, 11, 2, 6};

        findSub(arr, arr.length, list, 4, 9, 0);
        System.out.println(count);
    }

    private static void findSub(int[] arr, int n, ArrayList<Integer> list, int k, int x, int cur) {
        if(k == cur){
            Collections.sort(list);
            int diff = Math.abs(list.get(list.size()-1) - list.get(0));
            if(diff <= x)
                count+= 1;
            return;
        }
        if(n == 0) {

           // System.out.println(list);
            return;
        }

        ArrayList<Integer> include = new ArrayList<>(list);
        include.add(arr[n-1]);
        findSub(arr, n-1, include, k, x, cur+1);
        findSub(arr, n-1, list, k, x, cur);
    }
}
