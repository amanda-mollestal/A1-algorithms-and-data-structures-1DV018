package uppgift;

public class WQUnionFind {
    private int[] parent;
    private int[] size;

    public WQUnionFind(int N) {
        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int aRoot = root(a);
        int bRoot = root(b);

        if (aRoot != bRoot) {
            if (size[aRoot] < size[bRoot]) {
                parent[aRoot] = bRoot;
                size[bRoot] += size[aRoot];
            } else {
                parent[bRoot] = aRoot;
                size[aRoot] += size[bRoot];
            }
        }
    }

    private int root(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public void printNumbers() {
        for (int i = 0; i < parent.length; i++) {
            System.out.println("Parent: " + parent[i] + ", Size: " + size[i]);
        }
    }

}
