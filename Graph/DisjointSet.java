class DisjointSet {
    int parent[], rank[];

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;  // initially, each node is its own parent
            rank[i] = 0;    // rank starts from 0
        }
    }

    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return; // already in same set

        
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // Check if two nodes are connected
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);

        ds.union(0, 2);
        ds.union(4, 2);
        ds.union(3, 1);

        System.out.println(ds.isConnected(0, 4)); // true
        System.out.println(ds.isConnected(0, 1)); // false
    }
}
