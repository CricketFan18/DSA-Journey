public class RegularExpressionMatching {
    boolean dfs(int i, int j, String s, String p, Boolean[][] memo) {

        if (j == p.length())
            return i == s.length();

        if (memo[i][j] != null)
            return memo[i][j];

        boolean currentMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j)
                || p.charAt(j) == '.');

        boolean ans = false;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean skip = dfs(i, j + 2, s, p, memo);
            boolean take = currentMatch && dfs(i + 1, j, s, p, memo);
            ans = skip || take;
        } else {
            ans = currentMatch && dfs(i + 1, j + 1, s, p, memo);
        }
        return memo[i][j] = ans;
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p, memo);
    }
}
