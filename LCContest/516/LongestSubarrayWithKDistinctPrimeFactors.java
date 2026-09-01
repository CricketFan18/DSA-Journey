import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubarrayWithKDistinctPrimeFactors {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt();
        
        if (maxEl < 2) return n;

        // 1. Upgrade from Boolean Sieve to SPF (Smallest Prime Factor) Sieve
        int[] spf = new int[maxEl + 1];
        for (int i = 2; i <= maxEl; i++) {
            spf[i] = i; // Initialize every number's smallest prime factor as itself
        }
        for (int i = 2; i * i <= maxEl; i++) {
            if (spf[i] == i) { // If it's still itself, it's a prime
                for (int j = i * i; j <= maxEl; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i; // Mark the smallest prime factor for j
                    }
                }
            }
        }

        // 2. Fast Factorization using SPF
        List<Integer>[] primes = new List[n];
        for (int i = 0; i < n; i++) {
            List<Integer> t = new ArrayList<>();
            int num = nums[i];
            
            // This now takes O(log N) instead of O(maxEl)
            while (num > 1) {
                int prime = spf[num];
                t.add(prime);
                // Divide out all occurrences of this prime factor
                while (num % prime == 0) {
                    num /= prime;
                }
            }
            primes[i] = t;
        }

        // 3. Sliding Window (Using an array instead of HashMap for speed)
        int left = 0;
        int[] count = new int[maxEl + 1]; // Replaces the HashMap
        int distinctPrimes = 0;           // Tracks the equivalent of count.size()
        int ans = 0;

        for (int right = 0; right < n; right++) {
            // Union equivalent
            for (int p : primes[right]) {
                if (count[p] == 0) distinctPrimes++; // New distinct prime added
                count[p]++;
            }

            // Delete equivalent
            while (distinctPrimes > k) {
                for (int p : primes[left]) {
                    count[p]--;
                    if (count[p] == 0) distinctPrimes--; // Distinct prime completely removed
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
}
