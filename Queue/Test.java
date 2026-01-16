import java.util.Arrays;

public class Test {
    public static void swap(int[] ar,int a, int b) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    public static void main(String[] args) {
        int[] a ={5, 10};
        swap(a,0,1);
        System.out.println(Arrays.toString(a));
    }
}
