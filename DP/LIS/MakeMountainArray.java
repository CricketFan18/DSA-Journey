import java.util.Arrays;

public class MakeMountainArray {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LISf = new int[n];
        int[] LISb = new int[n];
        Arrays.fill(LISf, 1);
        Arrays.fill(LISb, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    LISf[i] = Math.max(LISf[i], LISf[j] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j])
                    LISb[i] = Math.max(LISb[i], LISb[j] + 1);
            }
        }
        int minRemoval = n;
        for (int i = 1; i < n - 1; i++) {
            minRemoval = Math.min(minRemoval, n - (LISf[i] + LISb[i] - 1));
        }
        return minRemoval;
    }
}
