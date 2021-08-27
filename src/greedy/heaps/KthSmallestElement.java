package greedy.heaps;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = {7, 10, 2, 3, 12, 5};
        System.out.println(findSmallest(arr, 4));
    }

    private static int findSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}
