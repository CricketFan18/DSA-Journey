import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ELevatorReqs {

    long[][][] memo;
    int m;
    int[] arr;

    public long dfs(int i, int j, int pos) {
        if (i == 0 && j == m - 1)
            return 0;

        if (memo[i][j][pos] != -1L)
            return memo[i][j][pos];

        int waiting = m - (j - i + 1);
        int currentFloor = (pos == 0) ? arr[i] : arr[j];

        long minCost = Long.MAX_VALUE;

        if (i > 0) // expand left
        {
            long distanceLeft = Math.abs(currentFloor - arr[i - 1]);
            long costLeft = (waiting * distanceLeft) + dfs(i - 1, j, 0);
            minCost = Math.min(minCost, costLeft);
        }
        if (j < m - 1) {
            long distanceRight = Math.abs(currentFloor - arr[j + 1]);
            long costRight = (waiting * distanceRight) + dfs(i, j + 1, 1);
            minCost = Math.min(minCost, costRight);
        }
        return memo[i][j][pos] = minCost;
    }

    public long elevatorRequests(int n, int start, int[] requests) {
        Set<Integer> uniqueFloors = new HashSet<>();
        uniqueFloors.add(start);
        for (int req : requests)
            uniqueFloors.add(req);

        m = uniqueFloors.size();
        arr = new int[m];
        int idx = 0;
        for (int floor : uniqueFloors)
            arr[idx++] = floor;
        Arrays.sort(arr);

        memo = new long[m][m][2];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(memo[i][j], -1L);

        int startIdx = -1;
        for (int i = 0; i < m; i++) {
            if (arr[i] == start) {
                startIdx = i;
                break;
            }
        }
        return dfs(startIdx, startIdx, 0);
    }
}