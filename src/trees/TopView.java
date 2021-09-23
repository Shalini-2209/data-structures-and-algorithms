package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    static class Pair{
        Node node;
        int degree;

        Pair(Node n, int d){
            node = n;
            degree = d;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println("Top View of a tree..");
        findTopView(root);
    }

    private static void findTopView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while ((!q.isEmpty())){
            Pair cur = q.poll();

            if(!map.containsKey(cur.degree))
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
