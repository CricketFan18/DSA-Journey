public class NumberOfSubseqWithEqualGCD {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int MOD = 1_000_000_007;

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        // dp[g1][g2] represents the number of ways to have seq1 GCD = g1 and seq2 GCD =
        // g2
        int[][] dp = new int[maxVal + 1][maxVal + 1];
        dp[0][0] = 1;
        for (int x : nums) {
            int[][] newDp = new int[maxVal + 1][maxVal + 1];

            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    if (dp[g1][g2] == 0)
                        continue;

                    long ways = dp[g1][g2];

                    newDp[g1][g2] = (int) ((newDp[g1][g2] + ways) % MOD);

                    int nextG1 = g1 == 0 ? x : gcd(g1, x);
                    newDp[nextG1][g2] = (int) ((newDp[nextG1][g2] + ways) % MOD);

                    int nextG2 = g2 == 0 ? x : gcd(g2, x);
                    newDp[g1][nextG2] = (int) ((newDp[g1][nextG2] + ways) % MOD);
                }
            }
            dp = newDp;
        }
        int ans = 0;
        for (int g = 1; g <= maxVal; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return ans;
    }
}
