package graphs;

import java.util.ArrayList;
import java.util.Collections;

class Edges implements Comparable<Edges>{
    int src;
    int dest;
    int weight;

    Edges(int u, int v, int w){
        src = u;
        dest = v;
        weight = w;
    }
    @Override
    public String toString(){
        return src + dest + "->" + weight;
    }

    @Override
    public int compareTo(Edges o) {
        return this.weight - o.weight;
    }
}
public class KruskalsAlgo {
    static ArrayList<Edges> list = new ArrayList<>();
    static DisjointSets ds = new DisjointSets();

    public static void main(String[] args) {
        KruskalsAlgo ka = new KruskalsAlgo();
        int v = 4;

        ds.makeSet(0);
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);

        ka.createEdge(0,1,4);
        ka.createEdge(1,2,1);
        ka.createEdge(2,3,1);
        ka.createEdge(3,1,5);

        getMST();
    }

    private static void createEdge(int u, int v, int w) {
        list.add(new Edges(u, v, w));
    }

    private static void getMST() {
        ArrayList<Pair> res = new ArrayList<>();
        Collections.sort(list);
        System.out.println("MINIMUM SPANNING TREE\n");
        for (int i = 0; i < list.size(); i++) {
            boolean possible = ds.union(list.get(i).src, list.get(i).dest);
            if(possible)  res.add(new Pair(list.get(i).src, list.get(i).dest));
        }
        System.out.println(res);
    }
}
