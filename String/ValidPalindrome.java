import java.util.Scanner;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        //System.out.println(s);
        int left = 0;
        int right = s.length()-1;
        while(left<right)
        {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (s.charAt(left) != s.charAt(right)) return false;
            // Move pointers
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean ans = isPalindrome(str);
        System.out.println(ans);
        sc.close();
    }
}
