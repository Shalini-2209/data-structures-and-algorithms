package trees;

public class TreeHeight {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(printHeight(root));
    }

    private static int printHeight(Node root) {
        if(root == null) return 0;

        int left = printHeight(root.left);
        int right = printHeight(root.right);

        return 1 + Math.max(left, right);
    }
}
