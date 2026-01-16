import java.util.Scanner;

public class Atoi {
    public static int myAtoi(String s) {
        int ans=0;
        int i=0;
        boolean neg = false;
        while(s.charAt(i)==' ') i++; //Whitespaces
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            neg = s.charAt(i) == '-';
            i++;
        }
        for( ; i < s.length() ; i++ ) {
            char ch = s.charAt(i);
            
            if(!Character.isDigit(ch)) {
                break;
            }               
            else {
                if(ans > (Integer.MAX_VALUE-(ch-'0'))/10 ) {
                    ans = Integer.MAX_VALUE+1;
                    break;
                }
                ans = ans*10 + (ch-'0');
                //System.out.println("ans: "+ans);
            }               
        }
        return neg? (-ans) : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String str = sc.nextLine();
        int ans = myAtoi(str);
        System.out.println(ans);
        sc.close();
    }
}
