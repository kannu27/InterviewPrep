
//https://leetcode.com/problems/graph-valid-tree/discuss/393538/very-simple-and-clean-solution-on-Java-(3-approaches-bfs-dfs-union-find)
//https://leetcode.com/problems/graph-valid-tree
//https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution  -MOST VOTED

class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(n < 2 ) return true;
        if(edges.length != n-1) return false;
        
        //build the list O(E + V)
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Integer>());        
        }
        
        for(int i = 0 ; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer>visited = new HashSet<Integer>();
        if(hasCycle(0,adjList,visited,-1)) return false;
        
        
        return visited.size() == n;
        
    }   
    private boolean hasCycle(int node, ArrayList<ArrayList<Integer>> adjList, Set<Integer> visited,int parent){
        visited.add(node);
        for(Integer neighbor : adjList.get(node)){
            if(neighbor == parent)  continue;
            if(visited.contains(neighbor) || hasCycle(neighbor,adjList,visited,node)) return true;
        }
        
        return false;
    }
}
