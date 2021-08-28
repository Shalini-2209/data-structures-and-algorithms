package stack;

import java.util.Stack;

public class NearestSmallestOnLeft {
    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 10, 2, 5};
        int ans[] = findNearestSmallest(arr, arr.length);

        for (int val: ans) {
            System.out.print(val + " ");
        }
    }

    private static int[] findNearestSmallest(int[] arr, int n) {
        int ans[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        ans[0] = -1;

        for (int i = 1; i < n; i++) {
            while(!stk.isEmpty() && arr[i] < stk.peek())
                stk.pop();

            if(stk.isEmpty())
                ans[i] = arr[i];
            else
                ans[i] = stk.peek();

            stk.push(arr[i]);
        }
        return ans;
    }
}
