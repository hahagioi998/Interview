package BitOperations;

public class FlipBits {
    public int reverse(int num){
        //assuming int is 32 bits.
        //不是inplace的flip，用另外的一个数字来记录
        int result = 0;
        int r1 = 1;

        //r1每次往左边移动1位，num是从左往右看，num和每一个bit上的1&可以看是bit是1还是0，如果是1的话
        for(int i=31; i >= 0; i--,r1<<=1){
            if((num & 1<<i) != 0){
                //如果是1的话，就加1，记住|是做加法的
                result = result | r1;
            }
        }
        return result;
    }


    public static void main(String args[]){
        FlipBits rb = new FlipBits();
        System.out.println(rb.reverse(418));
    }
}
