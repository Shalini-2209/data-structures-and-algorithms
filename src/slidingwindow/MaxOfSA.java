package slidingwindow;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class MaxOfSA {
    //Maximum of subarrays of size k

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 5,9,1};
        int k = 3;
        findMax(arr, k);
    }

    private static void findMax(int[] arr, int k) {
        int i=0, j=0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        while(j<arr.length) {
            while (!q.isEmpty() && q.peek() < arr[j]) q.poll();

            q.add(arr[j]);

            if (j - i + 1 < k) j++;

            else if(j - i + 1 == k) {
                list.add(q.peek());
                if (arr[i] == q.peek()) q.poll();
                i++;
                j++;
            }
        }

        System.out.println(list);
    }
}
