public class PrimeSum {
    public boolean isPrime(int num){
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public int largestPrime(int n) {
        if(n < 2) return 0;
        int sum = 2;
        int prime = 3;
        while(sum < n){
            if(!isPrime(prime)) {
                prime++;
                continue;
            }
            if(sum + prime <= n) {
                System.out.println(prime);
                sum+=prime;
            } 
            else
                break;
            prime++;
        }
        return sum;
    }

    public static void main(String[] args) {
        PrimeSum ob = new PrimeSum();
        System.out.println(ob.largestPrime(Integer.valueOf(args[0])));
    }
}
