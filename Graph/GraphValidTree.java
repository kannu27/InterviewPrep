
//https://leetcode.com/problems/graph-valid-tree/discuss/393538/very-simple-and-clean-solution-on-Java-(3-approaches-bfs-dfs-union-find)
//https://leetcode.com/problems/graph-valid-tree
//https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution  -MOST VOTED


///ALgo1: Using DFS for detect cycle in undirected graph
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


//Algo2: Weight Quick Union and finding connected components in undirected Graph
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n < 2) return true;
        UF uf = new UF(n);
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(uf.connected(x,y)) return false;
            uf.union(x,y);
        }
        return uf.segment == 1;
    }
    
    private static class UF {
        private int n;
        private int[] id;
        private int[] sz;
        private int segment;
        
        public UF(int n){
            this.n = n;
            id = new int[n];
            sz = new int[n];
            segment = n;
            for(int i =0; i < n; i++){
                id[i]=i;
                sz[i]=1;
            }
        }
        
        public int root(int x){
            while(id[x] != x){
                x = id[x];
            }
            return x;
        }
        
        public boolean connected(int i, int j){
            int x = root(i);
            int y = root(j);
            return x == y;
        }
        
        public void union(int i, int j){
            int x = root(i);
            int y = root(j);
            if(x == y) return;
            if(sz[x] < sz[y]){
                id[x] = y;
                sz[y] += sz[x];
            }else{
                id[y] = x;
                sz[x] += sz[y];
            }
            segment--;
        }
        
    }
}
