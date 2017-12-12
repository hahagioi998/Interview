package BinarySearch.BinarySearchCalculation;

//看对corner case 的考虑
//基本思想是不断地减掉除数，直到为0为止。但是这样会太慢。
//我们可以使用2分法来加速这个过程。不断对除数*2，直到它比被除数还大为止。加倍的同时，也记录下cnt，将被除数减掉加倍后的值，并且结果+cnt。
//<<左移就是*2，>>右移就是/2   b << n = b * 2^n
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //分母不能为0
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        //分子是0
        if (dividend == 0) {
            return 0;
        }

        //分子是最小整数，分母是-1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //判断结果是不是负数，要分别看除数和被除数的符号
        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);

        //如果是int的话要先把int转换成long，然后变成正整数Math.abs()
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int result = 0;
        //分子>=分母
        while(a >= b){//用while loop因为每次只能是*2的倍数，所以会跳过一段值
            //从0个2开始乘
            int shift = 0;
            //乘到比被除数大为止
            while(a >= (b << shift)){
                shift++;
            }

            //因为shift多加了一次，用shift-1才是2被乘了几次
            a -= b << (shift - 1);//再次找可不可以减掉除数
            result += 1 << (shift - 1);//最小是1
        }

        //根据判断结果是否为负数返回
        return isNegative? -result: result;
    }
}
