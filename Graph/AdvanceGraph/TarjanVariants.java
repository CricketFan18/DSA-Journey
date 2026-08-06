import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarjanVariants {

    int timer = 1;
    List<Integer> articulationPoints = new ArrayList<>();
    List<int[]> bridges = new ArrayList<>();

    public void dfs(int u, int parent, int[][] graph, int[] low, int[] tin) {
        tin[u] = low[u] = timer++;
        for (int v : graph[u]) {
            if (v == parent)
                continue;

            if (tin[v] == -1) {
                dfs(v, u, graph, low, tin);
                low[u] = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= tin[u])
                    articulationPoints.add(u);

                if (parent != -1 && low[v] > tin[u])
                    bridges.add(new int[] { u, v });
            } else {
                low[u] = Math.min(low[u],tin[v]);
            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 0, 2 },
                { 3, 5 },
                { 2, 4 },
                { 3 },
                { 2, 6, 8 },
                { 5, 7 },
                { 6, 8 },
                { 5, 7 }
        };
        int[] tin = new int[graph.length];
        Arrays.fill(tin, -1);
        int[] low = new int[graph.length];
    }
}
