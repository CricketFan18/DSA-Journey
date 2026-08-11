public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int x = s.length();
        int[][] dp = new int[x + 1][x + 1];
        String a = s;
        String b = new StringBuilder(s).reverse().toString();

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x][x];
    }
}
