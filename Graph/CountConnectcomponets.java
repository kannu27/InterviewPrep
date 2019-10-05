//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph


class CountConnectcomponets {
    public int countComponents(int n, int[][] edges) {
        if(n < 2) return n;
        UF uf = new UF(n);
        for(int i = 0; i < edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            uf.union(a,b);
        }
        return uf.segment;
    }
    
    class UF {
        private int N;
        private int[] id;
        private int[] sz;
        private int segment;
        
        public UF(int n){
            this.N  = n;
            segment = n;
            id = new int[n];
            sz = new int[n];
            for(int i = 0; i < n; i++){
                sz[i] = 1;
                id[i] = i;
            }
        }
        
        public int root(int i){
            while(id[i] != i){
                i = id[i];
            }
            return i;
        }
        
        public boolean find(int i, int j){
            int x = root(i);
            int y = root(j);
            return x == y;
        }
        
        public void union(int i, int j ){
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

