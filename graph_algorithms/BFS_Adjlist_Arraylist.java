/* Breadth First Search using Adjacency List */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Adjlist_Arraylist {
    int V; 
    List<List<Integer>> L;  
    BFS_Adjlist_Arraylist(int v) {
        this.V = v;
        L = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            L.add(new ArrayList<>()); 
    }

    public void add_edge(int u, int v) {
        L.get(u).add(v);
        L.get(v).add(u); 
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> Q = new LinkedList<>();
        visited[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.remove();
            System.out.print(u + " ");
            for (int v : L.get(u)) {
                if (!visited[v]) {
                    visited[v] = true; 
                    Q.add(v); 
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS_Adjlist_Arraylist G = new BFS_Adjlist_Arraylist(8); 
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
        int s = 0;
        System.out.print("BFS starting from vertex " + s + " is: ");
        G.bfs(s);
    }
}
