package trees;

public class LCA {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Node lca = findLCA(root, root.left, root.right);
        System.out.println(lca.data);
    }

    private static Node findLCA(Node root, Node p, Node q) {

        if(root == null || root == p || root == q) return root;

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}
