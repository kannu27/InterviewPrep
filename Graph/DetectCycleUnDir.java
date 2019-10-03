class DetectCycleUnDir
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
       boolean[] vis = new boolean[V];
       for(int i = 0; i < V; i++){
           if(!vis[i]){
               if(dfsHasCycle(i, list, vis, -1)) return true; 
           }
       }
       return false;
    }
    
    static boolean dfsHasCycle(int s, ArrayList<ArrayList<Integer>> list, boolean[] vis, int parent){
        vis[s] = true;
        for(int c : list.get(s)){
            if(!vis[c]) {
                if(dfsHasCycle(c,list,vis,s)) return true;
            }else{
                if(c != parent) return true;
            }
        }
        return false;
    }
}
