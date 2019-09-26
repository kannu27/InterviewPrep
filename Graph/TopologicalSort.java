/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<>Integer>list: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort
{
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
        if(N == 0) return null;
       boolean[] visited = new boolean[N];
       Stack<Integer> stack = new Stack<Integer>();
       for(int i = 0; i < N; i++){
           if(!visited[i]) topologicalSort(i, visited, stack, list);
       }
       
       int[] arr = new int[N];
       int i = 0;
       for(Integer num: stack){
           arr[i++] = num;
       }
       return arr;
    }
    
    static void topologicalSort(int v, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list){
        visited[v] = true;
        for(Integer adj : list.get(v)){
            if(!visited[adj]) topologicalSort(adj, visited, stack, list);
        }
        stack.push(v);
    }
}
