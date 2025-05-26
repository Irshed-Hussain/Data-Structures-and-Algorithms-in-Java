/* Finding articulation point from a graph G using DFS algorithm */

import java.util.ArrayList;
import java.util.List;

public class Art_Point_DFS {
    int V;
    List<List<Integer>> L;

    boolean[] visited;
    int[] dis_time;
    int[] lowest_point;
    boolean[] art_point;
    int time;

    Art_Point_DFS(int v) {
        V = v;
        L = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            L.add(new ArrayList<>());
        visited = new boolean[v];
        dis_time = new int[v];
        lowest_point = new int[v];
        art_point = new boolean[v];
        time = 0;
    }

    public void add_edge(int u, int v) {
        L.get(u).add(v);
        L.get(v).add(u);
    }

    public void dfs(int u, int parent) {
        visited[u] = true;
        dis_time[u] = lowest_point[u] = ++time;
        int children_root = 0;
        for (int v : L.get(u)) {
            if (!visited[v]) {
                children_root ++;
                dfs(v, u);
                lowest_point[u] = Math.min(lowest_point[u], lowest_point[v]);
                if (parent != -1 && lowest_point[v] >= dis_time[u])
                    art_point[u] = true;
            } else if (v != parent)
                lowest_point[u] = Math.min(lowest_point[u], dis_time[v]);
        }
        if (parent == -1 && children_root > 1)
            art_point[u] = true;
    }

    public void articulation_points() {
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, -1);
        }
        System.out.print("Articulation points in G are: ");
        for (int i = 0; i < V; i++) {
            if (art_point[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Art_Point_DFS G = new Art_Point_DFS(8);;
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
        G.articulation_points();
    }
}
