public class CountDerangements {

    // You are given N balls numbered from 1 to N and there are N baskets numbered
    // from 1 to N in front of you, the ith basket is meant for the ith ball.
    // Calculate the number of ways in which no ball goes into its respective basket.

    public int solveMem(int n, Integer[] dp) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        if (dp[n] != null)
            return dp[n];

        dp[n] = (n - 1) * (solveMem(n - 1, dp) + solveMem(n - 2, dp));
        return dp[n];
    }

    public int solveTab(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int first = dp[i - 1];
            int second = dp[i - 2];
            dp[i] = (i - 1) * (first + second);
        }
        return dp[n];
    }

    public int countDerangements(int n) {
        Integer[] dp = new Integer[n];
        return solveMem(n, dp);
    }
}
