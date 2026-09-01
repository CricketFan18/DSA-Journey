import java.util.ArrayList;
import java.util.List;

public class DetonateBombs {
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;
            List<Integer>[] graph = new List[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;

                    long dx = bombs[i][0] - bombs[j][0];
                    long dy = bombs[i][1] - bombs[j][1];
                    long r = bombs[i][2];

                    if (dx * dx + dy * dy <= r * r) {
                        graph[i].add(j);
                    }
                }
            }

            int maxBomb = 0;

            for (int i = 0; i < n; i++) {
                boolean[] vis = new boolean[n];
                maxBomb = Math.max(maxBomb, dfs(i, vis, graph));
            }

            return maxBomb;
        }

        public int dfs(int u, boolean[] vis, List<Integer>[] graph) {
            vis[u] = true;
            int count = 1;

            for (int v : graph[u]) {
                if (!vis[v]) {
                    count += dfs(v, vis, graph);
                }
            }
            return count;
        }
    }
}
