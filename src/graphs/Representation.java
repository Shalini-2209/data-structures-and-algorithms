package graphs;

import java.util.*;

public class Representation {
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        int v = 5;
        list = new ArrayList<>(v);

        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<Integer>());
        }

        createEdge(0, 1);
        createEdge(0, 4);
        createEdge(3, 1);
        createEdge(4, 1);

        printGraph();

        bfs(0, 3);
        dfs(0, 3);
        recursiveDfs(0, 3);

    }

    private static void recursiveDfs(int u, int v) {
        boolean vis[] = new boolean[list.size()];

        System.out.println("\nDFS Recursive Traversal:");
        dfsUtil(vis, u, v) ;

    }

    private static int dfsUtil(boolean[] vis, int u, int v) {
        System.out.print(u + " ");
        if(u == v) return 1;
        vis[u] = true;

        for (int next: list.get(u)) {
            if (!vis[next]) {
                if(dfsUtil(vis, next, v) == 1) return 1;
            }
        }
        return 0;
    }

    private static void dfs(int u, int v) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[list.size()];

        s.push(u);
        vis[u] = true;

        System.out.println("\nDFS Traversal: ");

        while(!s.isEmpty()){
            int cur = s.pop();
            System.out.print(cur + " ");
            if(cur == v) break;

            for (int next: list.get(cur)) {
                if(!vis[next]) {
                    s.push(next);
                    vis[next] = true;
                }
            }
        }
        System.out.println();
    }

    private static void bfs(int u, int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[list.size()];
        int parent[] = new int[list.size()];

        q.add(u);
        parent[u] = -1;
        vis[u] = true;

        System.out.println("\nBFS Traversal: ");
        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");

            if(cur == v) break;

            for (int neighbor: list.get(cur)){
                if(!vis[neighbor]) {
                    q.add(neighbor);
                    parent[neighbor] = cur;
                    vis[neighbor] = true;
                }
            }
        }
        System.out.println();

        int dest = v, dist = 0;

        while(parent[dest] != -1){
            dest = parent[dest];
            dist++;
        }
        System.out.println("The shortest distance between " + u + " and " + v + " is " + dist);
    }


    private static void createEdge(int u, int v) {
        // u => src v => dest
        list.get(u).add(v);
        list.get(v).add(u);
    }

    private static void printGraph() {
        System.out.println("Graph: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print("-> "+ list.get(i).get(j));
            }
            System.out.println();
        }
    }
}
