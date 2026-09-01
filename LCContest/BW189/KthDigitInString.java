public class KthDigitInString {
    public int kthDigit(long k) {
        k--;

        long digit = 1;
        long numbers = 9;

        while (k >= numbers * digit) {
            k -= numbers * digit;
            digit++;
            numbers *= 10;
        }

        long base_b = (digit == 1) ? 0 : (long) Math.pow(10, digit - 2);
        long b = base_b + (k / (digit * 10));

        long k_in_block = k % (digit * 10);
        long idx = k_in_block / digit;

        long target = 0;

        if (b == 0) {
            target = idx + 1;
        } else if (b % 2 == 0) {
            target = (10 * b) + idx;
        } else {
            target = (10 * b) + (9 - idx);
        }

        int offset = (int) (k_in_block % digit);
        String num = target + "";
        return num.charAt(offset) - '0';
    }
}
