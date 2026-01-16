import java.util.Scanner;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder("");
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            char ch1 = a.charAt(i--);
            char ch2 = b.charAt(j--);
            if (ch1 == '1' && ch2 == '1') {
                if (carry == 0)
                    ans = ans.insert(0, '0');
                else
                    ans = ans.insert(0, '1');
                carry = 1;
            } else if (ch1 == '1' || ch2 == '1') {
                if (carry == 0)
                    ans = ans.insert(0, '1');
                else {
                    ans = ans.insert(0, '0');
                }
            } else {
                ans = ans.insert(0, carry);
                carry=0;
            }
        }
        while(i >= 0) {
            char ch1 = a.charAt(i--);
            if(ch1 == '1') {
                if(carry == 1) {
                    ans = ans.insert(0, '0');
                } else {
                    ans = ans.insert(0, '1');
                }
            } else {
                ans = ans.insert(0, carry);
                carry = 0;
            }
        }
        while(j >= 0) {
            char ch1 = b.charAt(j--);
            if(ch1 == '1') {
                if(carry == 1) {
                    ans = ans.insert(0, '0');
                } else {
                    ans = ans.insert(0, '1');
                }
            } else {
                ans = ans.insert(0, carry);
                carry = 0;
            }
        }
        if( carry != 0) ans = ans.insert(0, carry);
        return ans.toString();
    }


    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            ans.append(sum % 2); 
            carry = sum / 2; 
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2: ");
        String str2 = sc.nextLine();
        String ans = addBinary(str1, str2);
        System.out.println(ans);
        sc.close();
    }
}