## Graph


1. we can use DFS to detect cycle in an undirected graph in O(V+E) time. 
We do a DFS traversal of the given graph. For every visited vertex ‘v’, 
if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph. 
If we don’t find such an adjacent for any vertex, we say that there is no cycle


https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/#graph
Questions
1. Clone Graph
2. Course Schedule
3. DFS/BFS
4. Detect cycle in undirect Graph
5. Detect cycel in directed graph
6. Topological Sort
7. Dijiktras 

Leetcode medium list - https://www.freecodecamp.org/news/coding-interviews-for-dummies-5e048933b82b/
Clone Graph
Course Schedule
Alien Dictionary
Pacific Atlantic Water Flow
Number of Islands
Graph Valid Tree
Number of Connected Components in an Undirected Graph
Longest Consecutive Sequence

Tips for DFS on matrix
https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/90739/python-dfs-bests-85-tips-for-all-dfs-in-matrix-question

Topological sort
https://algorithms.tutorialhorizon.com/topological-sort/
**Modified DFS:**

Use temporary stack to store the vertex.
Maintain a visited [] to keep track of already visited vertices.
In DFS we print the vertex and make recursive call to the adjacent vertices but here we will make the recursive call to the adjacent vertices and then push the vertex to stack.
Observe closely the previous step, it will ensure that vertex will be pushed to stack only when all of its adjacent vertices (descendants) are pushed into stack.
Finally print the stack.
For disconnected graph, Iterate through all the vertices, during iteration, at a time consider each vertex as source (if not already visited).

**Using Indegree**
https://www.cs.usfca.edu/~galles/visualization/TopoSortIndegree.html
