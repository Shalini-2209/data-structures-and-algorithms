package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        // Breadth first traversal
        printLevelOrderTraversal(root);
    }

    private static void printLevelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            root = q.poll();
            System.out.print(root.data + " ");
            if(root.left != null) q.add(root.left);
            if(root.right != null) q.add(root.right);
        }

    }
}
