import java.util.Scanner;

public class RemoveOuterParantheses {
    public static String removeOuterParentheses(String s) {
        int outer = 0;
        int inner = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(') {
                if(outer==0)
                    outer++;
                else {
                    inner++;
                    ans = ans.append(ch);
                }                    
            } else {
                if(inner!=0) {
                    ans = ans.append(ch);
                    inner--;
                } else 
                    outer--;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        String ans = removeOuterParentheses(str);
        System.out.println(ans+".");
        sc.close();
    }
}
