# Graph Algorithms #













## Applications of BFS ##
### 1. Checking bipartiteness of a graph $G=(V, E)$ ###
To check whether a given graph $G=(V, E)$ is **bipartite** or not, we can use BFS algorithm where we try to color the graph $G$ using two colors such that no two adjacent nodes share the same color. A graph is **bipartite** if we can split its vertices into two sets such that no edge connects nodes of the same set. 

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
- Time Complexity = $O(V+E)$ [For visiting each nodes, and edge once]
- Space Complexity = $O(V)$ [For the color array, and the Queue used in BFS]


### 2. Finding number of connected components for a graph $G=(V, E)$ ###
The number of connected components can be computed from an undirected graph using BFS algorithm. A connected component in a graph G=(V, E) is a maximal set of vertices such that every pair of vertices in the set is connected by a path.

#### Algorithm ####
- Initialize a *visited[]* array for all the nodes and set all to false
- For each *unvisited* node i:
  - Start a BFS from i
  - Mark all reachable nodes as *visited*
  - Collect the *visited* nodes into a component list
- Repeat until all nodes are visited.
