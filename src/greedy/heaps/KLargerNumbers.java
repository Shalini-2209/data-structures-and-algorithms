package greedy.heaps;

import java.util.PriorityQueue;

public class KLargerNumbers {
    public static void main(String[] args) {
        int arr[] = {7, 10, 2, 3, 12, 5};
        getKNumbers(arr, 4);
    }

    private static void getKNumbers(int[] arr, int k) {
       // Min queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k) pq.poll();
        }
        System.out.println(k + " largest elements in an array : " + pq);
    }
}
