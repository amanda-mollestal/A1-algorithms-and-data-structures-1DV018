package uppgift;

public class UnionFind {
    private int[] parent;

    public UnionFind(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    public boolean connected(int a, int b) {
        return parent[a] == parent[b];
    }

    public void union(int a, int b) {
        int aRoot = parent[a];
        int bRoot = parent[b];

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == aRoot) {
                parent[i] = bRoot;
            }
        }
    }

}