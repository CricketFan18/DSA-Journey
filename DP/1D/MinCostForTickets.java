public class MinCostForTickets {

    public int dfs(int idx, int[] days, int[] cost, Integer[] memo) {
        if (idx >= days.length)
            return 0;

        if (memo[idx] != null)
            return memo[idx];

        // take 1 day pass
        int costOne = cost[0] + dfs(idx + 1, days, cost, memo);

        // take 7 day pass
        int nextAvl = days[idx] + 7;
        int i = idx;
        while (i < days.length && days[i] < nextAvl)
            i++;
        int costSeven = cost[1] + dfs(i, days, cost, memo);

        // take 30 day pass
        nextAvl = days[idx] + 30;
        i = idx;
        while (i < days.length && days[i] < nextAvl)
            i++;
        int costThirty = cost[2] + dfs(i, days, cost, memo);

        memo[idx] = Math.min(costOne, Math.min(costSeven, costThirty));
        return memo[idx];
    }

    public int solveMemo(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length + 1];
        return dfs(0, days, costs, memo);
    }

    public int solveTab(int[] days, int[] costs) {
        int n = days.length;
        // dp[i] represents the min cost from index i to the end of the array.
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // take 1 day pass
            int costOne = costs[0] + dp[i + 1];

            // take 7 day pass
            int nextAvl = days[i] + 7;
            int idx = i;
            while (idx < n && days[idx] < nextAvl) {
                idx++;
            }
            int costSeven = costs[1] + dp[idx];

            // take 30 day pass
            nextAvl = days[i] + 30;
            idx = i;
            while (idx < n && days[idx] < nextAvl) {
                idx++;
            }
            int costThirty = costs[2] + dp[idx];

            dp[i] = Math.min(costOne, Math.min(costSeven, costThirty));
        }
        return dp[0];
    }

    public int mincostTickets(int[] days, int[] costs) {
        return solveTab(days, costs);
    }

}
