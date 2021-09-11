package slidingwindow;

import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class MaxOfSA {
    //Maximum of subarray of size k

    public static void main(String[] args) {
        int arr[] = {1,3,1,2,0,5};
        int k = 3;
        findMax(arr, k);
    }

    private static void findMax(int[] arr, int k) {
        int i=0, j=0;
        Deque<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        while(j<arr.length) {
            while (!q.isEmpty() && q.peekLast() < arr[j]) q.pollLast();

            q.addLast(arr[j]);
            //System.out.println(q);

            if (j - i + 1 < k) j++;

            else if(j - i + 1 == k) {
                list.add(q.peekFirst());
                if (arr[i] == q.peekFirst()) q.pollFirst();
                i++;
                j++;
            }
        }

        System.out.println(list);
    }
}
