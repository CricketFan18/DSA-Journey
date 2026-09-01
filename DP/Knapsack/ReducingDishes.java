import java.util.Arrays;

public class ReducingDishes {
    class Solution {

        int solveMem(int idx, int timer, int[] s, Integer[][] memo) {
            if (idx == s.length)
                return 0;

            if (memo[idx][timer] != null)
                return memo[idx][timer];

            // skip
            int skip = solveMem(idx + 1, timer, s, memo);

            // take
            int take = (timer * s[idx]) + solveMem(idx + 1, timer + 1, s, memo);

            return memo[idx][timer] = Math.max(skip, take);
        }

        int solveTab(int[] s) {
            Arrays.sort(s);
            int n = s.length;
            int[][] dp = new int[n + 1][n + 2];
            for (int idx = n - 1; idx >= 0; idx--) {
                for (int timer = n; timer >= 1; timer--) {

                    int skip = dp[idx + 1][timer];
                    int take = (timer * s[idx]) + dp[idx + 1][timer + 1];
                    dp[idx][timer] = Math.max(skip, take);
                }
            }
            return dp[0][1];
        }

        int solveTab2(int[] s) {
            Arrays.sort(s);
            int n = s.length;
            int[] curr = new int[n + 2];
            int[] next = new int[n + 2];
            for (int idx = n - 1; idx >= 0; idx--) {
                for (int timer = n; timer >= 1; timer--) {

                    int skip = next[timer];
                    int take = (timer * s[idx]) + next[timer + 1];
                    curr[timer] = Math.max(skip, take);
                }
                next = curr.clone();
            }
            return next[1];
        }

        public int maxSatisfaction(int[] satisfaction) {
            // Arrays.sort(satisfaction);
            // int n = satisfaction.length;
            // Integer[][] memo = new Integer[n + 1][n + 1];
            // return solveMem(0, 1, satisfaction, memo);
            return solveTab2(satisfaction);
        }
    }
}
