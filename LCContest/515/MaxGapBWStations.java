public class MaxGapBWStations {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        if (n == 1)
            return 0;
        int m = station.length();
        int[] earliest = new int[n];
        int[] latest = new int[n];
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (skill.charAt(i) == station.charAt(j)) {
                earliest[i] = j;
                i++;
            }
            j++;
        }
        i = n - 1;
        j = m - 1;
        while (i >= 0 && j >= 0) {
            if (skill.charAt(i) == station.charAt(j)) {
                latest[i] = j;
                i--;
            }
            j--;
        }
        int ans = 0;
        for (int x = 1; x < n; x++) {
            ans = Math.max(ans, latest[x] - earliest[x - 1]);
        }
        return ans;
    }
}
