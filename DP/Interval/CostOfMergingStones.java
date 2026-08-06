public class CostOfMergingStones {

    int solve(int i, int j, int[] prefixSum, int k, Integer[][] memo) {
        if (i == j)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        int ans = (int) 1e9;

        // trying all mid points where left pile compiles to 1 pile
        for (int mid = i; mid < j; mid += k - 1) {
            int leftCost = solve(i, mid, prefixSum, k, memo);
            int rightCost = solve(mid + 1, j, prefixSum, k, memo);

            ans = Math.min(ans, leftCost + rightCost);
        }

        // if current interval [i..j] can be compiled into 1 pile
        if ((j - i) % (k - 1) == 0) {
            ans += (prefixSum[j + 1] - prefixSum[i]);
        }
        return memo[i][j] = ans;
    }

    int solveTab(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0)
            return -1;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (int) 1e9;
            }
        }
        // length of interval goes from to 2 to N
        for (int len = 2; len <= n; len++) {
            // i -> starting index
            for (int i = 0; i <= n - len; i++) {
                // j -> ending index
                int j = i + len - 1;

                // trying all mid points where left pile compiles to 1 pile
                for (int mid = i; mid < j; mid += k - 1) {
                    int leftCost = dp[i][mid];
                    int rightCost = dp[mid + 1][j];
                    dp[i][j] = Math.min(dp[i][j], leftCost + rightCost);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += (prefixSum[j + 1] - prefixSum[i]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int mergeStones(int[] stones, int k) {
        // int n = stones.length;
        // if ((n - 1) % (k - 1) != 0)
        // return -1;
        // int[] prefixSum = new int[n + 1];
        // for (int i = 0; i < n; i++) {
        // prefixSum[i + 1] = prefixSum[i] + stones[i];
        // }
        // Integer[][] memo = new Integer[n][n];
        // return solve(0, n - 1, prefixSum, k, memo);
        return solveTab(stones, k);
    }

}