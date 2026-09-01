import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class SkyLineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            int left = b[0];
            int right = b[1];
            int h = b[2];
            events.add(new int[] { left, -h });
            events.add(new int[] { right, h });
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            // TIE-BREAKER:
            // If X is the same, sort by height value.
            // 1. Two starts: -10 and -20. -20 comes first (taller start processed first).
            // 2. Two ends: 10 and 20. 10 comes first (shorter end processed first).
            // 3. Start and end: -10 and 20. -10 comes first (start processed before end).
            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int prevMax = 0;

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                map.put(-h, map.getOrDefault(-h, 0) + 1);
            } else {
                int count = map.get(h);
                if (count == 1)
                    map.remove(h);
                else
                    map.put(h, count - 1);
            }

            int currMax = map.lastKey();

            if (prevMax != currMax) {
                res.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }
        return res;
    }
}
