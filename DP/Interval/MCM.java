public class MCM {

    static int dfs(int i, int j, int[] ar, Integer[][] memo) {
        if (i >= j)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        int ans = (int) 1e9;
        for (int k = i; k < j; k++) {
            int leftCost = dfs(i, k, ar, memo);
            int rightCost = dfs(k + 1, j, ar, memo);
            ans = Math.min(ans, ar[i - 1] * ar[k] * ar[j] + leftCost + rightCost);
        }
        return memo[i][j] = ans;
    }

    static int solveTab(int[] ar) {
        int n = ar.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int ans = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int leftCost = dp[i][k];
                    int rightCost = dp[k + 1][j];
                    ans = Math.min(ans, ar[i - 1] * ar[k] * ar[j] + leftCost + rightCost);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n - 1];
    }

    static int solveTab2(int ar[]) {
        int n = ar.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {

            for (int i = 1; i <= n - len; i++) {

                int j = i + len - 1;
                int ans = (int) 1e9;

                for (int k = i; k < j; k++) {
                    int leftCost = dp[i][k];
                    int rightCost = dp[k + 1][j];
                    ans = Math.min(ans, ar[i - 1] * ar[k] * ar[j] + leftCost + rightCost);
                }
                dp[i][j] = ans;
            }
        }

        return dp[1][n - 1];
    }

    static int matrixMultiplication(int arr[]) {
        // code here
        // int n = arr.length;
        // Integer[][] memo = new Integer[n][n];
        // return dfs(1, n - 1, arr, memo);
        return solveTab2(arr);

    }
}