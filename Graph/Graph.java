

// A Java program for Graph
import java.io.*; 
import java.util.*;
class Graph 
{ 
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; // Adjacency List 
  
    //Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v,int w) { adj[v].add(w); } 
}
