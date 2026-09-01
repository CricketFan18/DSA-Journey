public class CountEvenOddRatioI {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int count = 0;
        int n = nums.length;
        for (int left = 0; left < n; left++) {
            int x = 0;
            int y = 0;
            for (int right = left; right < n; right++) {
                if (nums[right] % 2 == 0)
                    x++;
                else
                    y++;

                if (y > 0 && x * b <= y * a)
                    count += 1;
            }
        }
        return count;
    }
}
