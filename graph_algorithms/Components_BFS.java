/* Find the number of connected components using BFS */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Components_BFS {
    int V; 
    List<List<Integer>> L;  
    Components_BFS(int v) {
        V = v;
        L = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            L.add(new ArrayList<>()); 
    }

    public void add_edge(int u, int v) {
        L.get(u).add(v);
        L.get(v).add(u); 
    }

    public void bfs(int s, boolean[] visited) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        visited[s] = true; 
        while (!Q.isEmpty()) {
            int u = Q.remove();
            for (int v : L.get(u)) {
                if (!visited[v]) {
                    visited[v] = true; 
                    Q.add(v); 
                }
            }
        }
    }

    public int count_components() {
        boolean[] visited = new boolean[V]; 
        int count = 0; 
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(i, visited); 
                count++; 
            }
        }
        return count; 
    }

    public static void main(String[] args) {
        Components_BFS G = new Components_BFS(13);
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
        G.add_edge(8, 9);
        G.add_edge(10, 11);
        G.add_edge(11, 12);
        System.out.println("Number of connected components: " + G.count_components());
    }
}
