import java.util.Scanner;

public class LengthOfLastWaord 
{
    public static int lengthOfLastWord(String s) {
        int len=0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' ') i--;
        while(i>=0 && s.charAt(i)!=' ') {
            i--;
            len++;
        }
        return len;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = lengthOfLastWord(str);
        System.out.println(ans);
        sc.close();

    }
}