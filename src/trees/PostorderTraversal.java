package trees;

import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.right.right = new Node(60);
        root.right.left.left = new Node(70);
        root.right.left.right = new Node(80);

        System.out.println("POSTORDER TRAVERSAL USING ITERATION AND RECURSION ");
        postorderUsingRec(root);
        System.out.println();
        postorderUsingIteration(root);
    }

    private static void postorderUsingIteration(Node root) {
        if(root == null) return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left != null) s1.push(root.left);
            if(root.right != null) s1.push(root.right);
        }

        while (!s2.isEmpty()){
            Node node = s2.pop();
            System.out.print(node.data + " ");
        }
     }

    private static void postorderUsingRec(Node root) {
        if(root == null) return;

        postorderUsingRec(root.left);
        postorderUsingRec(root.right);
        System.out.print(root.data + " ");
    }
}
