package graphs;

import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSorting {
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        int v = 5;
        list = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

        createEdge(0, 1);
        createEdge(0, 4);
        createEdge(3, 1);
        createEdge(4, 2);

        topologicalSortDfs(v);
        topologicalSortBfs(v);

    }

    private static void topologicalSortBfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[v];
        System.out.println("\nTOPOLOGICAL SORT USING BFS: ");
        // Increases the values of child nodes
        for (int i = 0; i < v; i++) {
            for (int edge: list.get(i)) {
                inDegree[edge]++;
            }
        }

        for (int i = 0; i < v; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int neighbor: list.get(cur)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) q.add(neighbor);
            }
        }

    }

    private static void topologicalSortDfs(int v) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        System.out.println("TOPOLOGICAL SORT USING DFS: ");
        for (int i = 0; i < v; i++) {
            if(!vis[i]) topologicalSortUtil(i, s, vis);
        }

        while(!s.isEmpty())
            System.out.print(s.pop() + " ");
    }

    private static void topologicalSortUtil(int cur, Stack<Integer> s, boolean[] vis) {
        vis[cur] = true;

        for (int neighbor: list.get(cur))
            if(!vis[neighbor]) topologicalSortUtil(neighbor, s, vis);

        s.push(cur);
    }

    private static void createEdge(int u, int v) {
        list.get(u).add(v);
    }
}