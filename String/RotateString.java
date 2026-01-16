import java.util.Scanner;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        return (s.length() != goal.length() && (s+s).contains(goal) );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str1 = sc.nextLine();
        System.out.println("Enter Goal: ");
        String str2 = sc.nextLine();       
        boolean ans =  rotateString(str1, str2);
        System.out.println(ans);
        sc.close();
    }
}
