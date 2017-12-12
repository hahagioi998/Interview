package BinarySearch.BinarySearchCalculation;

//计算a^n % b，其中a，b和n都是32位的整数。
//(a * b) % p = (a % p * b % p) % p
//将 a^n % b 分解为 (a^(n/2) * a^(n/2) * (a)) %b = ((a^(n/2) * a^(n/2))%b * (a)%b) %b = ((a^(n/2)%b * a^(n/2)%b)%b * (a)%b) %b
//註意2個base case: n = 0 n = 1都要特別處理。因為n = 1時，會分解出一個pow(a, b, 1)，這個會不斷循環調用。
public class FastPower {
    public int fastPower(int a, int b, int n) {
        //n/2的两种情况，odd and even
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }

        //问下一个recursion拿什么
        long product = fastPower(a, b, n / 2);

        //拿到以后做什么
        product = (product * product) % b;

        //如果n是基数
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }

    public static void main(String[] args){
        FastPower s = new FastPower();
        int res = s.fastPower(2, 3,3);
        System.out.println(res);
    }
}
