class CompletePrime {
    boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public boolean completePrime(int num) {
        if (!isPrime(num)) return false;
        int d=0;
        int temp = num;
        int suffix = 0;
        while(temp!=0){
            int r = temp%10;
            suffix = (int)(Math.pow(10,d)*r) + suffix;
            // System.out.println("Suffix: "+suffix);
            if(!isPrime(suffix))
                return false;
            d++;
            temp/=10;
        }
        temp = num / 10; 
        while (temp > 0) {
            if (!isPrime(temp)) return false;
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CompletePrime().completePrime(Integer.valueOf(args[0])));
    }
}