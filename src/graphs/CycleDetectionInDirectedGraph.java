package graphs;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
    public static void main(String[] args) {
        int v = 3;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        System.out.println(isCyclic(v, adj));
    }

    private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        boolean order[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if(!vis[i]) if(checkCycle(i, vis, order, adj)) return true;
        }

        return false;
    }

    private static boolean checkCycle(int cur, boolean[] vis, boolean[] order, ArrayList<ArrayList<Integer>> adj) {
        vis[cur] = true;
        order[cur] = true;

        for (int neighbor: adj.get(cur)) {
            if(!vis[neighbor]) if(checkCycle(neighbor, vis, order, adj)) return true;
            else if(order[neighbor]) return true;
        }

        order[cur] = false;
        return false;
    }
}
