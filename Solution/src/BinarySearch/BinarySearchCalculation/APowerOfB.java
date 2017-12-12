package BinarySearch.BinarySearchCalculation;

//power(2, 3) = 8
//power(-2, 5) = -32
//power(0, 10) = 0
//O(logn)
public class APowerOfB {
    public double power(double a, int b) {
        // assume b >= 0
        //smallest problem to solve
        if (b == 0) return 1;
        if (b == 1) return (long)a;

        boolean isNegative = false;
        if (b < 0) {
            isNegative = true;
        }

        //问下一层recursion拿什么
        int k = b / 2;
        int l = b - k * 2;

        double t1 = power(a, Math.abs(k));
        double t2 = power(a, Math.abs(l));

        if (isNegative) {
            return 1 / (t1 * t1 * t2);
        } else {
            return t1 * t1 * t2;
        }

//public double myPow(double x, long n) {
//        if (n < 0) {
//            x = 1 / x;
//            n = -n;
//        }
//
//        double ans = 1, tmp = x;
//
//        while (n != 0) {
//            if (n % 2 == 1) {
//                ans *= tmp;
//            }
//            tmp *= tmp;
//            n /= 2;
//        }
//        return ans;
    }
}
