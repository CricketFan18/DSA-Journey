import java.util.*;

public class ValidAnagram {
    
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map.put(ch1,map.getOrDefault(ch1, 0)+1);
            map.put(ch2,map.getOrDefault(ch2, 0)-1);
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        // int[] charCounts = new int[26]; // For 26 lowercase English letters

        // for (int i = 0; i < s.length(); i++) {
        //     charCounts[s.charAt(i) - 'a']++; // Increment for s
        //     charCounts[t.charAt(i) - 'a']--; // Decrement for t
        // }

        // // Check if all counts are zero
        // for (int count : charCounts) {
        //     if (count != 0) {
        //         return false;
        //     }
        // }
        return true;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2: ");
        String str2 = sc.nextLine();       
        boolean ans =  isAnagram(str1, str2);
        System.out.println(ans);
        sc.close();
    }
    
}
