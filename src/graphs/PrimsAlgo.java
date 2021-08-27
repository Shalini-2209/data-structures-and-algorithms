package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class MSTNode implements Comparable<MSTNode>{
    int vertex; // destination
    int weight;

    MSTNode(int vertex,int weight){
        this.weight = weight;
        this.vertex = vertex;
    }

    public String toString(){
        return vertex + ":" + weight;
    }

    @Override
    public int compareTo(MSTNode o) {
        return this.weight - o.weight;
    }
}

class Pair {
    int parent;
    int child;

    Pair(int p, int c){
        parent = p;
        child = c;
    }

    public String toString(){
        return parent + "-->" + child;
    }
}

public class PrimsAlgo {

    static ArrayList<ArrayList<MSTNode>> list;

    public static void main(String[] args) {
        int v = 4;
        list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList());
        }

        createEdge(0,1,3);
        createEdge(1,2,2);
        createEdge(0,3,4);
        createEdge(2,3,1);

        buildMST(v);

    }

    private static void buildMST(int v) {
        PriorityQueue<MSTNode> pq = new PriorityQueue<>();
        ArrayList<Pair> res = new ArrayList<>();
        int parent[] = new int[v];
        Arrays.fill(parent, -1);
        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean vis[] = new boolean[v];

        dis[0] = 0;
        pq.add(new MSTNode(0, 0));
        System.out.println("MINIMUM SPANNING TREE");

        while (!pq.isEmpty()){
            MSTNode cur = pq.poll();

            if(parent[cur.vertex] != -1 && vis[cur.vertex] == false){
                res.add(new Pair( parent[cur.vertex], cur.vertex));
            }
            vis[cur.vertex] = true;

            for (MSTNode neighbor: list.get(cur.vertex)) {
               if(!vis[neighbor.vertex] && dis[neighbor.vertex] > neighbor.weight){
                   parent[neighbor.vertex] = cur.vertex;
                   dis[neighbor.vertex] = neighbor.weight;
                   pq.add(new MSTNode(neighbor.vertex, dis[neighbor.vertex]));
               }
            }
        }

        for (Pair pair: res) {
            System.out.println(pair);
        }

    }

    private static void createEdge(int u, int v, int w) {
        list.get(u).add(new MSTNode(v, w));
        list.get(v).add(new MSTNode(u, w));
    }
}
