# Graph Algorithms #

## Memory representation of a graph ##
- Adjacency List
- Adjacency Matrix









## Breadth First Search (BFS) ##
```java
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
```

### Applications of BFS ###
### *1. Checking bipartiteness of a graph G=(V, E)* ###
To check whether a given graph G=(V, E) is **bipartite** or not, we can use BFS algorithm, where we try to color the graph G using two colors such that no two adjacent nodes share the same color. A graph is **bipartite** if we can split its vertices into two sets such that no edge connects nodes of the same set. 

#### Properties of a bipartite graph ####
- A graph is **bipartite** if and only if it is **2-colorable**
- A graph is **bipartite** if and only if it contains **no cycles of odd length**.

#### Algorithm ####
- Initialize a *color[]* array for all nodes with *-1* (unvisited)
- For every *unvisited* node, run BFS algorithm:
  - Assign a color *0* or *1* to the start node
  - For each neighbor:
    - If *unvisited*, assign the opposite color and continue
    - If *visited* and has the same color, the graph is not bipartite
- If no conflict is found, he graph is *bipartite*

#### Complexity ####
- Time Complexity = O(V+E) [For visiting each nodes, and edge once]
- Space Complexity = O(V) [For the color[] array, and the queue used in BFS, input space (adjacency list) = O(V+E)]


### *2. Finding number of connected components for a graph G=(V, E)* ###
The number of connected components can be computed from an undirected graph using BFS algorithm. A connected component in a graph G is a maximal set of vertices such that every pair of vertices in the set is connected by a path.

#### Algorithm ####
- Initialize a *visited[]* array for all the nodes and set all to false
- For each *unvisited* node u:
  - Start a BFS from u
  - Mark all reachable nodes as *visited*
  - Collect the *visited* nodes into a component list
- Repeat until all nodes are *visited*.

#### Complexity ####
- Time Complexity = O(V+E) [For visiting each nodes, and edge once]
- Space Complexity = O(V) [For the visited[] array, and the queue used in BFS, input space (adjacency list) = O(V+E)]



## Depth First Search (DFS) ##
```java
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
```

### Applications of DFS ###
### *1. Finding Topological Order / Topological Sort* ###
In a DAG, a topological order or topological sort is a sequence of all the vertices such that for every edge u -> v, u appears before v in the sequence. It is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before vertex v in the ordering. Applications of topological order includes task scheduling / dependency graph (find a valid execution order respecting dependencies), checking cycles in a graph (since we can only find topological ordering on a DAG, if topological order not possible, then there exist cycle in a directed graph).

#### Algorithm ####
- Maintain a *visited[]* array to track visited nodes
- Perform DFS from each unvisited node
- After visiting all neighbors of a node, push it onto a *stack*
- After all DFS calls are complete, *pop* from the *stack* to get the topological order

#### Complexity ####
- Time Complexity = O(V+E) [For visiting each nodes, and edge once]
- Space Complexity = O(V) [For the visited[] array, and the stack used in DFS, input space (adjacency list) = O(V+E)]

### *2. Finding Articulation Points* ###
Finding *articulation points* (or *cut vertices*) in an undirected graph using DFS can be find out using **Tarjan’s algorithm**. An articulation point is a vertex that, when removed, increases the number of connected components in the graph. Applications of finding articulation point includes transportation (identifying critical road junctions), social network analysis (community bridging users).

#### Algorithm ####
- Perform DFS and maintain the discovery times and low values for each vertex
- For each vertex, check if it is an articulation point based on the following conditions:
  - If the root of the DFS tree has two or more children
  - If any other vertex v has a child u such that no vertex reachable from u can connect back to one of v's ancestors

#### Complexity ####
- Time Complexity = O(V+E) [For visiting each nodes, and edge once]
- Space Complexity = O(V) [For the arrays, and the stack used in DFS, input space (adjacency list) = O(V+E)]

### *3. Finding Strongly Connected Components* ###
A **Strongly Connected Component (SCC)** in a directed graph is a maximal subset of vertices such that *every vertex is reachable from every other vertex in the subset*. Kosaraju's algorithm can be used to find the SCC from a directed graph G. In undirected graphs, the equivalent idea is finding the connected components. However, in directed graphs, connectivity is stricter (must be two-way reachable), so we find out SCC. The applications of SCC includes social network analysis, reducing a graph into a DAG, making further analysis easier.

#### Algorithm ####
- Run DFS on graph G to compute the finishing times of each vertex and store the vertices in a stack
- Transpose the graph G to G' (reverse the direction of all edges)
- Run DFS again on graph G' in the order defined by the stack
- Each DFS tree in the step-3 is a strongly connected component

#### Complexity ####
- Time Complexity = O(V+E) [For visiting each nodes, and edge once]
- Space Complexity = O(V) [For the arrays, and the stack used in DFS, input space (adjacency list) = O(V+E)]
