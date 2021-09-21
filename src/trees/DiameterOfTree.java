package trees;

public class DiameterOfTree {
    static int max;
    public static void main(String[] args) {
        max = Integer.MIN_VALUE;
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        findDiameter(root);
        System.out.println("Diameter of a given tree: " + max);
    }

    private static int findDiameter(Node root) {
        if(root == null) return 0;

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);
        max = Math.max(max, left + right + 1);
        return 1 + Math.max(left, right);
    }
}
