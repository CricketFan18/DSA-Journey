public class CheckASCIIPal {
    public boolean isPalindromic(String s) {
        int n = s.length();
        String[] bins = new String[n];
        for (int i = 0; i < n; i++) {
            int num = (int) s.charAt(i);
            String bit = String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');
            bins[i] = bit;
        }
        StringBuilder pal = new StringBuilder();
        for (int i = 0; i < n; i++) {
            pal.append(bins[i]);
        }
        int i = 0;
        int j = pal.length() - 1;
        while (i < j) {
            if (pal.charAt(i++) != pal.charAt(j--))
                return false;
        }
        return true;
    }
}
