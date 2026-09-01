public class StockWithFee {
    int dfs(int idx, int state, int[] prices, int fee, Integer[][] memo) {
        if (idx >= prices.length)
            return 0;

        if (memo[idx][state] != null)
            return memo[idx][state];

        int profit = 0;
        if (state == 0) // 0 -> not holding stock
        {
            int buy = -prices[idx] + dfs(idx + 1, 1, prices, fee, memo);
            int skip = dfs(idx + 1, 0, prices, fee, memo);
            profit = Math.max(buy, skip);
        } else // 1 -> holding stock
        {
            int sell = (prices[idx] - fee) + dfs(idx + 1, 0, prices, fee, memo);
            int skip = dfs(idx + 1, 1, prices, fee, memo);
            profit = Math.max(sell, skip);
        }
        return memo[idx][state] = profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int[] hold = new int[n];
        // int[] sell = new int[n];
        // hold[0] = -prices[0];
        // for(int i=1;i<n;i++)
        // {
        // hold[i] = Math.max(hold[i-1],sell[i-1]-prices[i]);
        // sell[i] = Math.max(sell[i-1],(hold[i]+prices[i]-fee));
        // }
        // return sell[n-1];
        Integer[][] memo = new Integer[n][2];
        return dfs(0, 0, prices, fee, memo);
    }
}
