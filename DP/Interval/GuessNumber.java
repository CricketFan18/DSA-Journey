public class GuessNumber {

    public int dfs(int start, int end, Integer[][] memo) {
        if (start >= end)
            return 0;

        if (memo[start][end] != null)
            return memo[start][end];

        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int leftPath = dfs(start, i - 1, memo);
            int rightPath = dfs(i + 1, end, memo);
            ans = Math.min(ans, i + Math.max(leftPath, rightPath));
        }
        return memo[start][end] = ans;
    }

    public int solveTab(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int start = n; start >= 1; start--) {
            for (int end = start; end <= n; end++) {
                if (start == end)
                    continue;
                else {
                    int ans = Integer.MAX_VALUE;
                    for (int i = start; i <= end; i++) {
                        int leftPath = dp[start][i - 1];
                        int rightPath = dp[i + 1][end];
                        ans = Math.min(ans, i + Math.max(leftPath, rightPath));
                    }
                    dp[start][end] = ans;
                }
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount(int n) {
        // Integer[][] memo = new Integer[n + 1][n + 1];
        // return dfs(1, n, memo);
        return solveTab(n);
    }

}
