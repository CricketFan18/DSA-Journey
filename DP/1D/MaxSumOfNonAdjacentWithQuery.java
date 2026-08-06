public class MaxSumOfNonAdjacentWithQuery {
    public int dfs(int idx, int[] nums, Integer[] dp) {
        if (idx >= nums.length)
            return 0;

        if (dp[idx] != null)
            return dp[idx];

        // skip
        int skip = dfs(idx + 1, nums, dp);

        // take
        int take = nums[idx] + dfs(idx + 2, nums, dp);

        dp[idx] = Math.max(skip, take);
        return dp[idx];
    }

    public int solveMemo(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        int sum = 0;
        for (int[] q : queries) {
            Integer[] dp = new Integer[nums.length];
            nums[q[0]] = q[1];
            sum = ((sum % MOD) + (dfs(0, nums, dp) % MOD)) % MOD;
        }
        return sum;
    }

    public int tabHelper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            int skip = dp[i + 1];
            int take = nums[i] + dp[i + 2];
            dp[i] = Math.max(take, skip);
        }
        return dp[0];
    }

    public int solveTab(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        int sum = 0;
        for (int[] q : queries) {
            nums[q[0]] = q[1];
            sum = ((sum % MOD) + (tabHelper(nums) % MOD)) % MOD;
        }
        return sum;
    }

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        return solveMemo(nums, queries);
    }
}
