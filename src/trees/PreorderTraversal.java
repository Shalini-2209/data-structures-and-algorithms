package trees;

import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(11);
        root.left = new Node(22);
        root.right = new Node(33);
        root.left.left = new Node(44);
        root.right.left = new Node(55);
        root.right.right = new Node(66);
        root.right.left.left = new Node(77);
        root.right.left.right = new Node(88);

        System.out.println("PREORDER TRAVERSAL USING ITERATION AND RECURSION ");
        printPreorderUsingRec(root);
        System.out.println();
        printPreorderUsingIteration(root);

    }

    private static void printPreorderUsingIteration(Node root) {
        if(root == null) return;

        Stack<Node> stk = new Stack<>();
        stk.push(root);

        while(!stk.isEmpty()){
            root = stk.pop();
            System.out.print(root.data + " ");
            if(root.right != null) stk.push(root.right);
            if(root.left != null) stk.push(root.left);
        }

    }

    private static void printPreorderUsingRec(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        printPreorderUsingRec(root.left);
        printPreorderUsingRec(root.right);
    }
}
