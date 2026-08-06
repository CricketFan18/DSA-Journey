public class BurstBallons {
    int solve(int left, int right, int[] paddedNums, Integer[][] memo) {
        // Base case: No balloons strictly between left and right
        if (left + 1 == right) {
            return 0;
        }
        if (memo[left][right] != null)
            return memo[left][right];

        int maxCoins = 0;
        for (int k = left + 1; k < right; k++) {
            // k is the right boundary for the left subproblem
            int leftCost = solve(left, k, paddedNums, memo);

            // k is the left boundary for the right subproblem
            int rightCost = solve(k, right, paddedNums, memo);

            // When k bursts, its only neighbors left are the fixed boundaries
            int currentCost = paddedNums[left] * paddedNums[k] * paddedNums[right];

            maxCoins = Math.max(maxCoins, leftCost + rightCost + currentCost);
        }

        return memo[left][right] = maxCoins;
    }

    int solveTab(int[] nums) {
        int n = nums.length;
        int[] paddedNums = new int[n + 2];
        paddedNums[0] = 1;
        paddedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            paddedNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {

                    int currentCost = paddedNums[left] * paddedNums[k] * paddedNums[right];

                    dp[left][right] = Math.max(
                            dp[left][right],
                            dp[left][k] + dp[k][right] + currentCost);
                }
            }
        }
        return dp[0][n + 1];
    }

    public int maxCoins(int[] nums) {
        // int n = nums.length;
        // int[] paddedNums = new int[n + 2];
        // paddedNums[0] = 1;
        // paddedNums[n + 1] = 1;
        // for (int i = 0; i < n; i++) {
        //     paddedNums[i + 1] = nums[i];
        // }
        // Integer[][] memo = new Integer[n + 2][n + 2];

        // // We want to burst everything strictly between index 0 and index n + 1
        // return solve(0, n + 1, paddedNums, memo);
        return solveTab(nums);
    }
}
