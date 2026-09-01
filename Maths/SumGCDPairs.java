import java.util.Arrays;
// 3867

public class SumGCDPairs {
    public long gcd(long a, long b) {
        return b % a == 0 ? a : gcd(b % a, a);
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;
        long max = 0;
        long[] prefixGCD = new long[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = gcd(nums[i], max);
        }
        long sum = 0;
        Arrays.sort(prefixGCD);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            sum += (gcd(prefixGCD[l], prefixGCD[r]));
            l++;
            r--;
        }
        return sum;
    }
}
