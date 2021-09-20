package trees;

import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {

        /*
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("INORDER TRAVERSAL USING ITERATION AND RECURSION ");
        inorderUsingIteration(root);
        System.out.println();
        inorderUsingRec(root);
    }

    private static void inorderUsingRec(Node root) {
        if(root == null) return;

        inorderUsingRec(root.left);
        System.out.print(root.data + " ");
        inorderUsingRec(root.right);
    }

    private static void inorderUsingIteration(Node root) {
        Stack<Node> stk = new Stack<>();
        Node cur = root;

        while(!stk.isEmpty() || cur != null){
            if(cur != null){
                // Traverses through left until it reaches the null node
                stk.push(cur);
                cur = cur.left;
            }
            else{
                // When it reaches null, pop and point the cur to it's right child
                cur = stk.pop();
                System.out.print(cur.data + " ");
                cur = cur.right;
            }
        }
    }
}
