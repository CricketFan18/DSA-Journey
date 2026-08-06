public class StocksCooldown {
    public int dfs(int idx, int canBuy, int[] prices, Integer[][] memo) {
        if (idx >= prices.length)
            return 0;

        if (memo[idx][canBuy] != null)
            return memo[idx][canBuy];

        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[idx] + dfs(idx + 1, 0, prices, memo);
            int skip = dfs(idx + 1, 1, prices, memo);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + dfs(idx + 2, 1, prices, memo);
            int skip = dfs(idx + 1, 0, prices, memo);
            profit = Math.max(sell, skip);
        }
        memo[idx][canBuy] = profit;
        return memo[idx][canBuy];
    }

    public int solveMemo(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2];
        return dfs(0, 1, prices, memo);
    }

    public int solveTab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    int buy = -prices[idx] + dp[idx + 1][0];
                    int skip = dp[idx + 1][1];
                    profit = Math.max(buy, skip);
                } else {
                    int sell = prices[idx] + dp[idx + 2][1];
                    int skip = dp[idx + 1][0];
                    profit = Math.max(sell, skip);
                }
                dp[idx][canBuy] = profit;
            }
        }
        return dp[0][1];
    }

    public int solveStateMachine(int[] prices) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = hold[i - 1] + prices[i];
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);

        }
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }
    public int solveStateMachine2(int[] prices) {
        int n = prices.length;
        int sell = 0;
        int cooldown = 0;
        int hold = -prices[0];
        for (int i = 1; i < n; i++) {
            int nextHold = Math.max(hold, cooldown - prices[i]);
            int nextSell = hold + prices[i];
            int nextCooldown = Math.max(cooldown, sell);

            sell = nextSell;
            hold = nextHold;
            cooldown = nextCooldown;

        }
        return Math.max(sell, cooldown);
    }

    public int maxProfit(int[] prices) {
        return solveStateMachine(prices);
    }
}
