class UF {
	// union-find, bfs
	int N;
	int[] id;
	int[] sz;
	int segments;
	public UF(int n){
		N = n;
		segments = n;
		id = new int[N];
	    sz = new int[N];
		for(int i=0; i<N; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}	
	public int root(int i) {
		while(i!=id[i]){
			id[i] = id[id[i]]; // path compression
			i = id[i];
		}
		return i;
	}
	public void connect(int p, int q){
		int i = root(p);
		int j = root(q);
		if(i == j) return;
		if(sz[i]<sz[j]) { // if-else: weighted quick-union
			id[i] = j;
			sz[j] += sz[i];
		}
		else if(sz[i]>sz[j]) {
			id[j] = i;
			sz[i] += sz[j];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];
		}
		segments--;
	}
	public boolean connected(int p, int q) {
		if(root(p)==root(q)){
			return true;
		}
		return false;
	}
}
