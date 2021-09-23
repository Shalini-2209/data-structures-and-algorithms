package trees;

import java.util.ArrayList;

public class LeftView {
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        list = new ArrayList<>();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);

        findLeftView(root, 0);

        System.out.println(list);
    }

    private static void findLeftView(Node root, int level) {
        if(root == null) return;

        if(list.size() == level)
            list.add(root.data);

        findLeftView(root.left, level + 1);
        findLeftView(root.right, level + 1);
    }
}
