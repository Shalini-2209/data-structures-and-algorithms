package trees;

import java.util.ArrayList;

public class RightView {
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        list = new ArrayList<>();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);

        findRightView(root, 0);

        System.out.println("Right view of tree..");
        System.out.println(list);
    }

    private static void findRightView(Node root, int level) {
        if(root == null) return;

        if(level == list.size()) list.add(root.data);

        findRightView(root.right, level+1);
        findRightView(root.left, level+1);
    }
}
