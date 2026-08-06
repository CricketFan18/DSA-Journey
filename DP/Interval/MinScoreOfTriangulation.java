public class MinScoreOfTriangulation {

    int solveMem(int i, int j, int[] values, Integer[][] memo) {
        if (i + 1 == j)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];
        int ans = (int) 1e9;
        for (int k = i + 1; k < j; k++) {
            int left = solveMem(i, k, values, memo);
            int right = solveMem(k, j, values, memo);
            int currentCost = values[i] * values[k] * values[j];
            ans = Math.min(ans, left + currentCost + right);
        }

        return memo[i][j] = ans;
    }

    int solveTab(int[] v) {
        int n = v.length;
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], v[i] * v[k] * v[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        Integer[][] memo = new Integer[n][n];
        return solveMem(0, n - 1, values, memo);
    }
}
