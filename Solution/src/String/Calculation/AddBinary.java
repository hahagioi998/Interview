package String.Calculation;

public class AddBinary {
    public String addBinary(String a, String b) {
        //define ans
        String ans = "";

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            //initialize sum with carry
            int sum = carry;
            //加两个数，减掉'0'
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;

            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            //因为是binary，二进制，所以sum是要%2才是真正的结果
            //应该用stringbuilder去append更好
            ans = (sum % 2) + ans;
            //carry是sum/2
            carry = sum / 2;
        }
        //最后要处理一下carry
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }
}
