import java.util.Arrays;

class BinaryPalindrome {
    int findMinOps(int num){
        if (num == 0) return 0;
        String s = Integer.toBinaryString(num);
        int n = s.length();
        int right = n-1;
        int left = 0;
        int total = 0;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) {
                total += (int)(Math.pow(2,n-right-1));
            }
            left++;
            right--;
        }
        return total;
    }
    
    public int[] minOperations(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = findMinOps(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( new BinaryPalindrome().minOperations(new int[]{1,2,4})));
    }
    
}