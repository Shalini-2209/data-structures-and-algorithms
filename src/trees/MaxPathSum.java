package trees;

// Height based problems

public class MaxPathSum {

    static int max;
    public static void main(String[] args) {
        max  = Integer.MIN_VALUE;
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        findMaxSum(root);
        System.out.println(max);
    }

    private static int findMaxSum(Node root) {
        if(root == null) return 0;

        int left =  Math.max(0, findMaxSum(root.left));
        int right = Math.max(0, findMaxSum(root.right));

        max = Math.max(max, left + right + root.data);
        return root.data + Math.max(left, right);
    }
}
