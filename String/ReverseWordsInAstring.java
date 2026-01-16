import java.util.Scanner;

public class ReverseWordsInAstring {
    public static String reverseWords(String s) 
    {
        String[] ar = s.split("\\s+");
        String ans = "";
        for(int i=ar.length-1;i>=0;i--)
        {
            ans+=(ar[i]+" ");
        }
        return ans.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String rev = reverseWords(str);
        System.out.println(rev);
        sc.close();
    }
}
