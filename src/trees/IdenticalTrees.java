package trees;

public class IdenticalTrees {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println("The given trees are identical: " + isIdentical(root1, root2));
    }

    private static boolean isIdentical(Node p, Node q) {
        if(p == null || q == null)  return (p == q);

        return p.data == q.data && isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }
}
