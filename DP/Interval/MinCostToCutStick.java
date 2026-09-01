import java.util.Arrays;

public class MinCostToCutStick {
    public int dfs(int i, int j, int[] cuts, Integer[][] memo) {

        if (i >= j)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        int ans = (int) 1e9;
        for (int k = i + 1; k < j; k++) {
            int left = dfs(i, k, cuts, memo);
            int right = dfs(k, j, cuts, memo);
            ans = Math.min(ans, left + right + (cuts[j] - cuts[i]));
        }
        if (ans == (int) 1e9)
            return memo[i][j] = 0;
        return memo[i][j] = ans;
    }

    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] ar = new int[len + 2];
        ar[0] = 0;
        ar[len + 1] = n;
        for (int i = 1; i <= len; i++) {
            ar[i] = cuts[i - 1];
        }
        Arrays.sort(ar);
        Integer[][] memo = new Integer[len + 2][len + 2];
        return dfs(0, len + 1, ar, memo);
    }
}
