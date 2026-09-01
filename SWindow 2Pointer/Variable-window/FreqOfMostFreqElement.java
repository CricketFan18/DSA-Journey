import java.util.Arrays;

public class FreqOfMostFreqElement {

    public int maxFrequency2(int[] nums, int k) {
        // Step 1: Sort the array so we always target the maximum element in the window
        Arrays.sort(nums);
        
        int left = 0;
        int maxLen = 0;
        long currentSum = 0; // Use long to prevent integer overflow!
        
        for (int right = 0; right < nums.length; right++) {
            // Expand the window by adding the new element to our running sum
            currentSum += nums[right];
            
            // Calculate the total operations required for the current window
            long windowSize = right - left + 1;
            long targetSum = windowSize * nums[right];
            long opsRequired = targetSum - currentSum;
            
            // If operations exceed our budget 'k', shrink the window from the left
            while (opsRequired > k) {
                currentSum -= nums[left];
                left++;
                
                // Recalculate based on the new, smaller window
                windowSize = right - left + 1;
                targetSum = windowSize * nums[right];
                opsRequired = targetSum - currentSum;
            }
            
            // The window is now valid, record its size
            maxLen = Math.max(maxLen, (int) windowSize);
        }
        
        return maxLen;
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = nums[0];
        int maxLen = 1;
        int left = 0;
        
        long remainingK = k; 
        
        for (int right = 1; right < nums.length; right++) {
            int curr = nums[right];
            
            long opsReq = (long) (right - left) * (curr - prev);
            
            while (left <= right && opsReq > remainingK) {
                remainingK += prev - nums[left];
                left++;
                opsReq = (long) (right - left) * (curr - prev);
            }
            
            remainingK -= opsReq;
            prev = curr;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
