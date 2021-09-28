package trees;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        ArrayList<Integer> list = new ArrayList<>();

        if(!isLeaf(root)) list.add(root.data);
        addLeftBoundary(root, list);
        addLeaves(root, list);
        addRightBoundary(root, list);

        System.out.println(list);
    }

    private static void addLeaves(Node root, ArrayList<Integer> list) {
        if(isLeaf(root)) {
            list.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, list);
        if(root.right != null) addLeaves(root.right, list);
    }

    private static void addRightBoundary(Node root, ArrayList<Integer> list) {
        Stack<Node> s = new Stack<>();
        Node cur = root.right;

        while(cur != null){
            if(!isLeaf(cur)) s.push(cur);
            if(cur.right != null) cur = cur.right;
            else cur = cur.left;
        }

        while(!s.isEmpty())
            list.add(s.pop().data);

    }

    private static void addLeftBoundary(Node root, ArrayList<Integer> list) {
        Node cur = root.left;

        while(cur != null){
            if(!isLeaf(cur)) list.add(cur.data);
            if(cur.left != null) cur = cur.left;
            else cur = cur.right;
        }
    }

    private static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}
