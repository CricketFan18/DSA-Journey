public class WeightedSumOfTree {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        int[] depth = new int[n];
        depth[0] = 1;
        int height = 1;
        for (int i = 0; i < n; i++) {
            height = Math.max(height, getDepth(i, parent, depth));
        }

        long weightedSum = 0L;
        for (int i = 0; i < n; i++) {
            weightedSum += (long) nums[i] * (height - depth[i] + 1);
        }

        return weightedSum;
    }

    private int getDepth(int i, int[] parent, int[] depth) {
        if (i == 0) {
            return 1;
        }
        if (depth[i] != 0) {
            return depth[i];
        }

        depth[i] = getDepth(parent[i], parent, depth) + 1;
        return depth[i];
    }
}
