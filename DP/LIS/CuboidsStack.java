import java.util.Arrays;

public class CuboidsStack {

    public int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids, (a, b) -> {
            if (a[2] != b[2])
                return Integer.compare(a[2], b[2]);
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int n = cuboids.length;
        int[] dp = new int[n];
        int maxTotalHeight = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            int[] base = cuboids[i];

            for (int j = 0; j < i; j++) {
                int[] curr = cuboids[j];
                if(base[0] <= curr[0] && base[1] <= curr[1] && base[2] <= curr[2])
                {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxTotalHeight = Math.max(dp[i],maxTotalHeight);
        }
        return maxTotalHeight;
    }
}