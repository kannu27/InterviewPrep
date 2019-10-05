private static class DisjointSet {
	private int[] ds;

	DisjointSet(int n) {
	  this.ds = new int[n];

	  for (int i = 0; i < n; i++) {
		ds[i] = i;
	  }
	}

	private int parent(int i) {
	  while (ds[i] != i) {
		ds[i] = ds[ds[i]];
		i = ds[i];
	  }

	  return i;
	}

	private void union(int i, int j) {
	  int rootX = parent(i);
	  int rootY = parent(j);

	  ds[rootX] = rootY;
	}
  }
