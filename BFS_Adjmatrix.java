/* Breadth First Search using Adjacency Matrix */

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Adjmatrix {

    public static void bfs(int[][] G, int s) {
        int n = G.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> Q = new LinkedList<>();
        visited[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.remove();
            System.out.print(u + " ");
            for (int v = 0; v < n; v++) {
                if (G[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    Q.add(v);
                }
            }
        }
    }
    public static void main (String[] args) {
        int[][] G = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
        int s = 0;
        System.out.print("BFS starting from vertex " + s + " is: ");
        bfs(G, s);
    }
}
