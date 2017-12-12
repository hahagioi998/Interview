package String.Calculation;
//Given x = 123, return 321
//x = -123, return -321
public class ReverseInteger {
    public int reverseInteger(int x) {//不是string
        // Write your code here
        //别忘了用long
        //想要从后往前拿数字就必须第一次%然后先/再%
        /*int reversed_n = 0;//存reversed n

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;//3->3+2->320+1
            n = n / 10;//12->1->0
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;//3->32->321
        }
        return reversed_n;*/
        //结果
        long ret = 0;//都要用long

        while (x != 0) {//想想while loop怎么设
            ret = ret * 10 + x % 10;//result*10就是进一位，x%10是最末尾
            x /= 10;//去掉最末尾
        }

        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)ret;//别忘了cast to int
    }
}
