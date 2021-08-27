package graphs;

public class FloydWarshallAlgo {
    static int INF = 1999;

    public static void main(String[] args) {
        int v = 4;
        int[][] graph = {
                {0,   3,   6,   -15},
                {INF, 0,  2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };
        findPaths(graph, v);
    }

    private static void findPaths(int[][] graph, int v) {
        int dis[][] = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dis[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if(dis[i][k] == INF || dis[k][j] == INF)
                        continue;
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        if(!checkForNegativeCycle(dis, v)) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    System.out.print(dis[i][j] + " ");
                }
                System.out.println("\n");
            }
        }
    }

    private static boolean checkForNegativeCycle(int[][] dis, int v) {
        // if diagonals become less than 0, then it confirms -ve cycle
        for (int i = 0; i < v; i++) {
            if(dis[i][i] < 0)
                System.out.println("Negative cycle exists..");
            return true;
        }
        return false;
    }
}
