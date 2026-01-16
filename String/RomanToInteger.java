import java.util.Scanner;

public class RomanToInteger {
    private static int getRomanValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static int romanToInt(String s) {
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(i+1 < s.length() && getRomanValue(s.charAt(i)) < getRomanValue(s.charAt(i+1))) {
                ans = ans + (getRomanValue( s.charAt(i+1)) - getRomanValue(s.charAt(i)));
                ++i;
            } else {
                ans = ans + getRomanValue(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        int ans = romanToInt(str);
        System.out.println(ans);
        sc.close();
    }
}
