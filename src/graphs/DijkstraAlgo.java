package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int weight;
    int vertex;

    Node(int weight, int vertex){
        this.weight = weight;
        this.vertex = vertex;
    }

    public String toString(){
        return "Weight: " +weight + " Connected to: " + vertex;
    }

    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

public class DijkstraAlgo {
    static ArrayList<ArrayList<Node>> list;

    static void createEdge(int w, int v1, int v2){
        list.get(v1).add(new Node(w, v2));
        list.get(v2).add(new Node(w, v1));
    }

    static void findShortestPath(int v, int src){
        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dis[src] = 0;
        pq.add(new Node(0, src));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for (Node neighbor: list.get(cur.vertex) ) {
                if(dis[cur.vertex] + neighbor.weight < dis[neighbor.vertex]){
                    dis[neighbor.vertex] = dis[cur.vertex] + neighbor.weight;
                    pq.add(new Node(dis[neighbor.vertex], neighbor.vertex));
                }
            }
        }

        for (int i = 0; i < v; i++) {
        System.out.println(dis[i]);
        }

    }

    public static void main(String[] args) {
        int v = 5;
        list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        createEdge(3, 0, 1);
        createEdge(1, 0, 2);
        createEdge(7, 1,2);
        createEdge(5, 1,3);
        createEdge(1,1,4);
        createEdge(2,2,3);
        createEdge(7,3,4);

        findShortestPath(v, 0);

    }
}
