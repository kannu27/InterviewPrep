/** In directed graph, the cycle detection using dfs needs not to check for backedge
https://www.geeksforgeeks.org/detect-cycle-in-a-graph/**/

class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        boolean[] visited = new boolean[V];
        HashSet<Integer> recursiveTrack = new HashSet<Integer>();
        for(int v = 0; v < V; v++){
            if(!visited[v]){
                if(dfs(list, visited, v,recursiveTrack)) return true;
            }
        }
        return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, int v,HashSet<Integer> recursiveTrack)
    {
        if(visited[v]  && recursiveTrack.contains(v)) return true;
        visited[v] = true;
        recursiveTrack.add(v);
        for(Integer neighbor : list.get(v)){
            if(dfs(list, visited, neighbor,recursiveTrack)) return true;
            
        }
        recursiveTrack.remove(v);
        return false;
    }
    
    
}
