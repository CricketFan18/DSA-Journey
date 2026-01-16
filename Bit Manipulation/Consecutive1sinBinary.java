import java.util.Scanner;

public class Consecutive1sinBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxCount = 0;
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
            n >>= 1; // shift right
        }
        System.out.println(maxCount);
        sc.close();
    }

}
