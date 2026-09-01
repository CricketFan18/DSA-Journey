public class MinimizeWaitingTime {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = arrivalTime.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = arrivalTime[i] % period;
        }
        int maxWait = 0;
        int maxGreen = Arrays.stream(lights).max().getAsInt();
        for (int i = 0; i < n; i++) {
            if (r[i] >= maxGreen)
                maxWait = Math.max(maxWait, period - r[i]);
        }
        return maxWait;
    }
}
