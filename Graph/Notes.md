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
