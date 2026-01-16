import java.util.Scanner;

public class MaxDepthOfParantheses {
    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = Integer.MIN_VALUE;
        for(char ch : s.toCharArray())
        {
            if(ch=='(') depth++;
            if(ch==')') depth--;
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();
        int ans = maxDepth(str);
        System.out.println(ans);
        sc.close();
    }
}
