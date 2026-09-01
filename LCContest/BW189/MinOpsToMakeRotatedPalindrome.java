public class MinOpsToMakeRotatedPalindrome {
    public int minOperations(String s) {
        int n = s.length();
        s = s + s;
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String p = s.substring(i, i + n);
            int currentCost = i;
            int x = 0;
            int y = n - 1;
            while (x < y) {
                int diff = Math.abs(p.charAt(x) - p.charAt(y));
                currentCost += Math.min(diff, 26 - diff);
                x++;
                y--;
            }
            cost = Math.min(cost, currentCost);
        }
        return cost;
    }
}
