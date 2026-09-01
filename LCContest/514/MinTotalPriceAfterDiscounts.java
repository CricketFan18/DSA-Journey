import java.util.Arrays;

public class MinTotalPriceAfterDiscounts {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n = discounts.length;
        int m = prices.length;
        int i = n-1;
        int j = m-1;
        double sum = 0.0d;
        while(i>=0 && j>=0) {
            sum += ((double)prices[j] * (100 - discounts[i]))/100.0;
            i--;
            j--;
        }
        while(j>=0)
        {
            sum += prices[j];
            j--;
        }
        return sum;
    }

}
