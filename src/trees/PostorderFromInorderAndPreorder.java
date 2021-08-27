package trees;

import java.util.HashMap;

public class PostorderFromInorderAndPreorder {
    static int preIndex = 0;
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int n = 6;

        for (int i = 0; i < in.length; i++)
            map.put(in[i], i);

        findPostOrder(in, pre, 0, n-1, map);
    }

    private static void findPostOrder(int[] in, int[] pre, int start, int end, HashMap<Integer, Integer> map) {
        // Base
        if(start > end) return;

        // Hypothesis
        int root = map.get(pre[preIndex++]);

        // left subtree
        findPostOrder(in, pre, start, root - 1, map);
        // right subtree
        findPostOrder(in, pre, root+1, end, map);


        // Induction
        System.out.print(in[root] + " ");
    }
}
