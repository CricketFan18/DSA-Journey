public class MaximalSquare {
    int maxArea = 0;

    public int dfs(int i, int j, char[][] matrix, Integer[][] memo) {
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        int right = dfs(i, j + 1, matrix, memo);
        int diag = dfs(i + 1, j + 1, matrix, memo);
        int down = dfs(i + 1, j, matrix, memo);

        if (matrix[i][j] == '1') {
            int ans = 1 + Math.min(right, Math.min(diag, down));
            memo[i][j] = ans;
            maxArea = Math.max(ans * ans, maxArea);
            return ans;
        } else {
            memo[i][j] = 0;
            return 0;
        }

    }

    public int solveMemo(char[][] matrix) {
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];
        dfs(0, 0, matrix, memo);
        return maxArea;
    }

    public int solveTab(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r + 1][c + 1];
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int right = dp[i][j + 1];
                int diag = dp[i + 1][j + 1];
                int down = dp[i + 1][j];

                if (matrix[i][j] == '1') {
                    int ans = 1 + Math.min(right, Math.min(diag, down));
                    dp[i][j] = ans;
                    maxArea = Math.max(ans * ans, maxArea);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxArea;
    }

    public int solveTabOptimized1(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] curr = new int[c + 1];
        int[] next = new int[c + 1];
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int right = curr[j + 1];
                int diag = next[j + 1];
                int down = next[j];

                if (matrix[i][j] == '1') {
                    int ans = 1 + Math.min(right, Math.min(diag, down));
                    curr[j] = ans;
                    maxArea = Math.max(ans * ans, maxArea);
                } else {
                    curr[j] = 0;
                }
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return maxArea;
    }

    public int maximalSquare(char[][] matrix) {
        return solveTab(matrix);
    }

}