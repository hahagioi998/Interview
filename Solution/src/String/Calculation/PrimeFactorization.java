package String.Calculation;

import java.util.ArrayList;
import java.util.List;
//20 is a composite number. 20 = 1 x 20, 2 x 10, or 4 x 5. Factors of 20: 1, 2, 4, 5, 10, 20. Prime factorization: 20 = 2 x 2 x 5, which can also be written 20 = 2² x 5.
public class PrimeFactorization {
    public List<Integer> primeFactorization(int num) {
        List<Integer> factors = new ArrayList<>();
        //从2开始，不可能比sqrt(num）更大
        for (int i = 2; i * i <= num; i++) {
            //说明可以整除, 但这里是用while
            while (num % i == 0) {
                //除
                num = num / i;
                //把除数加进去
                factors.add(i);
            }
        }
        //把num加进去，这是最后剩下的数
        if (num != 1) {
            factors.add(num);
        }

        return factors;
    }

    public static void main(String[] args){
        PrimeFactorization solution = new PrimeFactorization();
        List<Integer> res = solution.primeFactorization(20);
        System.out.println(res);
    }
}
