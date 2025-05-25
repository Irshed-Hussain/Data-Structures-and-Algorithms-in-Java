/* Topological order / topological sort on a Directed Acyclic Graph G=(V, E) using DFS */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topol_Order_DFS {
    int V; 
    List<List<Integer>> L;  
    Topol_Order_DFS(int v) {
        V = v;
        L = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            L.add(new ArrayList<>()); 
    }

    public void add_edge(int u, int v) {
        L.get(u).add(v);
        L.get(v).add(u); 
    }

    public void dfs(int u, boolean[] visited, Stack<Integer> S) {
        visited[u] = true; 
        for (int v : L.get(u)) {
            if (!visited[v])
                dfs(v, visited, S); 
        }
        S.push(u);
    }

    public List<Integer> topol_order() {
        Stack<Integer> S = new Stack<>(); 
        boolean[] visited = new boolean[V]; 
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, S);
        }
        List<Integer> list = new ArrayList<>();
        while (!S.isEmpty())
            list.add(S.pop()); 
        return list; 
    }

    public static void main(String[] args) {
        Topol_Order_DFS G = new Topol_Order_DFS(6); 
        G.add_edge(5, 2);
        G.add_edge(5, 0);
        G.add_edge(4, 0);
        G.add_edge(4, 1);
        G.add_edge(2, 3);
        G.add_edge(3, 1);
        List<Integer> list = G.topol_order();
        System.out.println("Topological Order: " + list);
    }
}
