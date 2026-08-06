public class CombSumIV {
    public int dfs(int remain, int[] nums, Integer[] dp) {
        if (remain < 0)
            return 0;

        if (remain == 0)
            return 1;

        if (dp[remain] != null)
            return dp[remain];

        int ways = 0;
        for (int i = 0; i < nums.length; i++)
            ways += dfs(remain - nums[i], nums, dp);

        dp[remain] = ways;
        return dp[remain];
    }

    public int solveMem(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return dfs(target, nums, dp);
    }

    public int solveTab(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        return solveTab(nums, target);
    }
}
