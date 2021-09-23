package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    static class Pair{
        Node node;
        int degree;

        Pair(Node n, int d){
            node = n;
            degree = d;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of a tree..");
        findBottomView(root);
    }

    private static void findBottomView(Node root) {
        Map<Integer, Node> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()){
            Pair cur = q.poll();
            map.put(cur.degree, cur.node);

            if(cur.node.left != null)
                q.offer(new Pair(cur.node.left, cur.degree - 1));
            if(cur.node.right != null)
                q.offer(new Pair(cur.node.right, cur.degree + 1));
        }

        for (int key: map.keySet()) {
            System.out.print(map.get(key).data + " ");
        }
    }
}
