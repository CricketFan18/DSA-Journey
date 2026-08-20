public class RedundantConnections {

    public int[] parent;
    public int[] size;

    private int find(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = find(parent[node]);
    }

    private boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV)
            return false;

        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++)
        {
            parent[i] = i;
            size[i] = 1;
        }

        int[] res = new int[2];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if(!union(u, v))
                res = edge;
        }
        return res;
    }
}