import java.util.Scanner;

public class LargestOddNumber {
    public static String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;--i)
        {
            char ch = num.charAt(i);
            int lastnum = Integer.valueOf(ch)-48;
            if(lastnum%2!=0)
            {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = largestOddNumber(str);
        System.out.println(ans);
        sc.close();
    }
}
