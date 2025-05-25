/* BFS algorithm implementation where graph G=(V,E) is represented as an adjacency list using Java Collection LinkedList */

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Adjlist_Linkedlist {
    int V; 
    LinkedList<Integer>[] L;
    
    @SuppressWarnings("unchecked")
    BFS_Adjlist_Linkedlist(int v) {
        V = v;
        L = new LinkedList[v];
        for (int i=0; i<v; i++)
            L[i] = new LinkedList<>(); 
    }

    public void add_edge(int u, int v) {
        L[u].add(v);
        L[v].add(u); 
    }

    public void bfs_algo(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> Q = new LinkedList<>();
        visited[s] = true;
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.remove();
            System.out.print(u + " ");
            for (int v : L[u]) {
                if (!visited[v]) {
                    visited[v] = true; 
                    Q.add(v); 
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS_Adjlist_Linkedlist G = new BFS_Adjlist_Linkedlist(8);
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
        G.bfs_algo(s);
    }
}
