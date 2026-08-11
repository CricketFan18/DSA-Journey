import java.util.Arrays;

public class A {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n = discounts.length;
        int m = prices.length;
        int i;
        double sum = 0.0d;
        for (i = n - 1; i >= 0; i--) {
            sum += ((double)prices[i] * (100 - discounts[i]))/100.0;
        }
        i = m - n;
        while(i>=0)
        {
            sum += prices[i];
        }
        return sum;
    }

}
