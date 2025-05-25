/* Find whether a graph is bipartite or not using BFS */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite_BFS {
    int V; 
    List<List<Integer>> L;  
    Bipartite_BFS(int v) {
        V = v;
        L = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            L.add(new ArrayList<>()); 
    }

    public void add_edge(int u, int v) {
        L.get(u).add(v);
        L.get(v).add(u); 
    }

    public boolean test_bipartiteness() {
        int[] color = new int[V]; 
        Arrays.fill(color, -1); 
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { 
                if (!bfs(i, color)) 
                    return false; 
            }
        }
        return true; 
    }

    private boolean bfs(int s, int[] color) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        color[s] = 0; 
        while (!Q.isEmpty()) {
            int u = Q.remove();
            for (int v : L.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u]; 
                    Q.add(v); 
                } else if (color[v] == color[u])
                    return false; 
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        Bipartite_BFS G = new Bipartite_BFS(8); 

        //// A bipartite graph
        // G.add_edge(0, 1);
        // G.add_edge(0, 3);
        // G.add_edge(1, 2);
        // G.add_edge(2, 3);
        // G.add_edge(2, 4);

        // A non-bipartite graph
        G.add_edge(0, 1);
        G.add_edge(0, 2);
        G.add_edge(1, 2);
        G.add_edge(1, 3);
        G.add_edge(1, 4);
        G.add_edge(3, 4);
        G.add_edge(2, 4);
        G.add_edge(4, 5);
        G.add_edge(2, 6);
        G.add_edge(2, 7);
        G.add_edge(6, 7);
        boolean g = G.test_bipartiteness();
        if (g == true) 
            System.out.println("The graph is bipartite!");
        else
            System.out.println("The graph is not bipartite!");
    }
}
