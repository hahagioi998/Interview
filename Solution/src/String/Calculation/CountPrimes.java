package String.Calculation;
//找n以内的质数, Count the number of prime numbers less than a non-negative number, n.
//2是最小的质数
public class CountPrimes {
//    O(n^1.5)
//    public int countPrimes(int n) {
//        int count = 0;
//        for (int i = 1; i < n; i++) {
//            if (isPrime(i)) count++;
//        }
//        return count;
//    }
//
//    private boolean isPrime(int num) {
//        if (num <= 1) return false;
//        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
//        // to avoid repeatedly calling an expensive function sqrt().
//        for (int i = 2; i * i <= num; i++) {
//            //说明能整除
//            if (num % i == 0) return false;
//        }
//        return true;
//    }

    // O(n) memory and its runtime complexity is O(n log log n)
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            //不是prime就跳过
            if (!isPrime[i]) continue;
            //all multiples of the number that is smaller than n is not prime
            //用j = j+i
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        //最后数一遍
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
