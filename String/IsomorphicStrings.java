import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            System.out.println(map1);
            System.out.println(map2);
            if(map1.containsKey(s.charAt(i))) { // S->T
                if(map1.get(s.charAt(i)) != t.charAt(i))
                return false;;
            }
            else {
                map1.put(s.charAt(i), t.charAt(i));
            }

            if(map2.containsKey(t.charAt(i))) { // T->S
                if(map2.get(t.charAt(i)) != s.charAt(i))
                return false;;
            }
            else {
                map2.put(t.charAt(i), s.charAt(i));
            }           
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2: ");
        String str2 = sc.nextLine();       
        boolean ans =  isIsomorphic(str1, str2);
        System.out.println(ans);
        sc.close();
    }
}
