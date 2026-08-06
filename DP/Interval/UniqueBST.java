public class UniqueBST {

    int solve(int n, Integer[] memo) {
        if (n <= 1)
            return 1;

        if (memo[n] != null)
            return memo[n];

        int ans = 0;
        for (int i = 1; i <= n; i++)
            ans += solve(i - 1, memo) * solve(n - i, memo);

        return memo[n] = ans;
    }

    int solveTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        return dp[n];
    }

    public int numTrees(int n) {
        return solveTab(n);
    }
}