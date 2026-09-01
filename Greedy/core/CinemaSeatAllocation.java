package Greedy.core;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> seats = new HashMap<>();
        for (int[] reserved : reservedSeats) {
            int row = reserved[0];
            int seat = reserved[1];
            seats.put(row, seats.getOrDefault(row, 0) | (1 << seat));
        }
        int rowsLeft = n - seats.size();
        int count = 2 * rowsLeft;

        // Bit index matching seat number: 10_9_8_7_6_5_4_3_2_1_0
        int LEFT = 0b0_1_1_1_1_0_0_0_0_0_0;
        int MID = 0b0_0_0_1_1_1_1_0_0_0_0;
        int RIGHT = 0b0_0_0_0_0_1_1_1_1_0_0;

        for (Map.Entry<Integer, Integer> entry : seats.entrySet()) {
            Integer currentMask = entry.getValue();
            boolean leftFree = (currentMask & LEFT) == 0;
            boolean rightFree = (currentMask & RIGHT) == 0;
            boolean midFree = (currentMask & MID) == 0;

            if (leftFree && rightFree)
                count += 2;
            else if (leftFree || midFree || rightFree)
                count += 1;
        }
        return count;
    }

    public int maxNumberOfFamilies2(int n, int[][] reservedSeats) {
        Map<Integer, boolean[]> seats = new HashMap<>();
        for (int[] reserved : reservedSeats) {
            int row = reserved[0];
            int seat = reserved[1];
            if (!seats.containsKey(row))
                seats.put(row, new boolean[11]);
            seats.get(row)[seat] = true;
        }
        int rowsLeft = n - seats.size();
        int count = 2 * rowsLeft;
        for (Map.Entry<Integer, boolean[]> entry : seats.entrySet()) {
            int row = entry.getKey();
            boolean[] currentRow = entry.getValue();
            count += countGroups(currentRow, 2);
            count += countGroups(currentRow, 6);
            count += countGroups(currentRow, 4);
        }
        return count;
    }

    private int countGroups(boolean[] row, int start) {
        if (!row[start] && !row[start + 1] && !row[start + 2] && !row[start + 3]) {
            for (int j = start; j < start + 4; j++)
                row[j] = true;
            return 1;
        }
        return 0;
    }
}
