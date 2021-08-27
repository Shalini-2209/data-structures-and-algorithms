package graphs;

import java.util.ArrayList;
import java.util.Arrays;

class Edge{
    int vertex;
    int weight;

    Edge(int v, int w){
        vertex = v;
        weight = w;
    }

    public String toString(){
        return "Dest" + vertex + " Weight:" + weight;
    }
}

public class BellmanFordAlgo {

    static ArrayList<ArrayList<Edge>> list;
 
    public static void main(String[] args) {
        int v = 4;
        list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        createEdge(0,2,4);
        createEdge(0,1,5);
        createEdge(1,3,3);
        createEdge(2,1,-6);
        createEdge(3,2,2);
        findShortestPath(v);

    }

    private static void findShortestPath(int v) {
        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        System.out.println("SHORTEST PATH USING BELLMAN FORD \n");
        // Without negative cycle
        for (int i = 0; i < v-1; i++) {
            for (int j = 0; j < list.size(); j++) {
                int src = j;
                for (Edge neighbor: list.get(src)) {
                    if(dis[src] + neighbor.weight < dis[neighbor.vertex])
                        dis[neighbor.vertex] = dis[src] + neighbor.weight;
                }
            }
        }
        boolean flag = false;


        for (int i = 0; i < list.size(); i++) {
            for (Edge neighbor: list.get(i)) {
                if(dis[i] + neighbor.weight < dis[neighbor.vertex]) {
                    System.out.println("Negative weight cycle exists !!");
                    flag = true;
                    break;
                }
                if(flag) break;
            }
        }
        if(!flag) {
            for (int i = 0; i < v; i++)
                System.out.println("Shortest dist from 0 to " + i + " is " + dis[i]);
        }
    }

    private static void createEdge(int u, int v, int w) {
        list.get(u).add(new Edge(v, w));
    }
}
