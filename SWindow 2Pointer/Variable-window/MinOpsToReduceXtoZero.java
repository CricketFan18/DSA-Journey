public class MinOpsToReduceXtoZero {
  
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long sum = 0;
        int left = 0;
        long total = 0L;
        int ans = Integer.MAX_VALUE;
        for(int num : nums)
            total += (long)num;

        for(int right=0;right<n;right++)
        {
            sum += nums[right];
            long rem = total - sum;
            while(left<= right && rem < (long)x)
            {
                sum -= nums[left];
                rem = total - sum;
                left++;
            }

            int window = right-left+1;
            if(rem == x)
                ans = Math.min(ans,(n - window));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
