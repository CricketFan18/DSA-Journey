import java.util.Scanner;

public class IndexOfFirstOuccurenc {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int temp = i;
            int j = 0;
            while (j < needle.length() && haystack.charAt(temp) == needle.charAt(j)) {
                temp++;
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }        
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter haystack: ");
        String hs = sc.nextLine();
        System.out.println("Enter needle: ");
        String n = sc.nextLine();
        int ans = strStr(hs,n);
        System.out.println(ans);
        sc.close();
    }
        
}
