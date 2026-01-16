import java.util.Scanner;

public class Practise {
  public static int numSubarraysWithSum(int[] nums, int goal) {
    return atMost(nums, goal) - atMost(nums, goal - 1);
  }

  public static int atMost(int[] nums, int k) {
    int count = 0, left = 0, sum = 0;
    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];
      if (sum > k) {
        sum -= nums[left];
        left++;
      }
      count += (right - left + 1);
    }
    return count;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] ar = new int[n];
    for (int i = 0; i < n; i++) {
      ar[i] = sc.nextInt();
    }
    int goal = sc.nextInt();
    System.out.println(atMost(ar, goal));
    sc.close();
  }
}
