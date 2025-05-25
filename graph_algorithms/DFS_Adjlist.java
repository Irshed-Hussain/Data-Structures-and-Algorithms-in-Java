/* DFS algorithm implementation on graph G=(V, E) represented as adjacency list using Java Collection ArrayList */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS_Adjlist {
    int V; 
    List<List<Integer>> L;  
    DFS_Adjlist(int v) {
        V = v;
        L = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            L.add(new ArrayList<>()); 
    }

    public void add_edge(int u, int v) {
        L.get(u).add(v);
        L.get(v).add(u); 
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> S = new Stack<>();
        S.push(s);
        while (!S.isEmpty()) {
            int u = S.pop();
            if (!visited[u]) {
                System.out.print(u + " ");
                visited[u] = true;
            }
            for (int v : L.get(u)) {
                if (!visited[v])
                    S.push(v);
            }
        }
    }

    public static void main(String[] args) {
        DFS_Adjlist G = new DFS_Adjlist(5);
        G.add_edge(0, 1);
        G.add_edge(0, 2);
        G.add_edge(1, 3);
        G.add_edge(1, 4);
        int s = 0;
        System.out.print("DFS starting from vertex " + s + " is: ");
        G.dfs(s);
    }
}
