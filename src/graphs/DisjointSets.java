package graphs;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets {

    static Map<Integer, DisjointNode> map = new HashMap<>();

    static class DisjointNode{
        DisjointNode parent;
        int rank;
        int data;

        DisjointNode(int data){
            this.data = data;
            rank = 0;
        }

        public String toString(){
            return  parent.data + "-->" + data + "(rank: " + rank + ")";
        }
    }

    public static void main(String[] args) {
        DisjointSets ds = new DisjointSets();

        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(map);
    }

     boolean union(int data1, int data2) {
        DisjointNode node1 = map.get(data1);
        DisjointNode node2 = map.get(data2);

        // Finds the representative of both the nodes
        DisjointNode rep1 = findSet(node1);
        DisjointNode rep2 = findSet(node2);

        if(rep1 == rep2) return false;

        if(rep1.rank >= rep2.rank){
            rep1.rank = (rep1.rank == rep2.rank) ? rep1.rank + 1 : rep1.rank;
            rep2.parent = rep1;
        }
        else rep1.parent = rep2;

        return true;
    }

     DisjointNode findSet(DisjointNode node) {
        DisjointNode parent = node.parent;

        if(parent == node) return parent;
        node.parent = findSet(node.parent);
        return node.parent;
    }

    static void makeSet(int data) {
        DisjointNode node = new DisjointNode(data);

        node.parent = node;
        map.put(data, node);
    }
}

