# Graph Algorithms #














### Checking bipartiteness of a graph $G=(V, E)$ using BFS algorithm ###
To check whether a given graph $G=(V, E)$ is **bipartite** or not, we can use BFS algorithm where we try to color the graph $G$ using two colors such that no two adjacent nodes share the same color. A graph is **bipartite** if we can split its vertices into two sets such that no edge connects nodes of the same set. 

#### Properties of a bipartite graph ####
- A graph is **bipartite** if and only if it is **2-colorable**
- A graph is **bipartite** if and only if it contains **no cycles of odd length**.

#### Algorithm ####
Initialize a *color[]* array for all nodes with *-1* (unvisited)
For every *unvisited* node, run BFS algorithm:
  Assign a color *0* or *1* to the start node
  For each neighbor:
    If *unvisited*, assign the opposite color and continue
    If *visited* and has the same color, the graph is not bipartite
If no conflict is found, he graph is *bipartite*
