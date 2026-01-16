import java.util.Scanner;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for(String str:strs)
            minLength = Math.min(minLength, str.length());
        StringBuilder ans = new StringBuilder("");
        for (int cnt = 0; cnt < minLength; cnt++) {
            char check = strs[0].charAt(cnt);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(cnt) != check) {
                    return ans.toString(); // Mismatch found
                }
            }
            ans.append(check);
        }
        // boolean flag = true;
        // while(flag  && cnt<minLength)
        // {
        //     char check = strs[0].charAt(cnt);
        //     for(int i=1;i<strs.length;i++) {
        //         if(strs[i].charAt(cnt) != check) {
        //             flag=false;
        //             break;
        //         }
        //     }
        //     if(flag) {
        //         ans = ans.append(check);
        //         cnt++;
        //     }           
        // }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            strs[i]=sc.nextLine();
        }
        String rev = longestCommonPrefix(strs);
        System.out.println(rev);
        sc.close();
    }
}
