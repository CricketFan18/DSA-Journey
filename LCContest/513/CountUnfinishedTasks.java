public class CountUnfinishedTasks {

    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + tasks[i];
        }
        int[] res = new int[shifts.length];
        int tasksLeft = 0;
        long shift = 0;
        for (int i = 0; i < shifts.length; i++) {
            shift += shifts[i];
            int low = 0;
            int high = n + 1;
            while (low + 1 < high) {
                int mid = low + (high - low) / 2;
                if (prefix[mid] <= shift)
                    low = mid;
                else
                    high = mid;
            }
            tasksLeft = n - low;
            res[i] = tasksLeft;
            if(tasksLeft == 0)
                shift = 0;
        }
        return res;
    }
}