import java.util.Scanner;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static boolean areAlmostEqual(String s1, String s2) {
        if( s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int count=0;
        int x=-1,y=-1;
        for(int i=0 ; i < s1.length() ; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(x == -1) x=i;
                else        y=i;
            }               
            if(count>2)
                return false;
        }
        if(count!=2)    return false;

        return (s1.charAt(x)==s2.charAt(y) && s1.charAt(y)==s2.charAt(x));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean ans = areAlmostEqual(s1, s2);
        System.out.println(ans);
        sc.close();
    }
}
