package String.Calculation;
//   1 2 3
//     2 1
//----------
//   1  2 3
//2 4 6
//----------
//2 5 8 3
//3 2 1 0  index
public class MultiplyString {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();

        int[] ans = new int[l1 + l2 + 1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                ans[i + j] += (num1.charAt((l1 - 1) - i) - '0') * (num2.charAt(l2 - 1 - j) - '0');
            }
        }
        //这个时候ans的最小位0存的是最后的位，往前推是对
        for (int i = 0; i < l1 + l2; i++) {
            ans[i + 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        //注意如果最左边是0的话要去掉,i必须>=1
        int i = l1 + l2;
        while (ans[i] == 0 && i >= 1) {
            i--;
        }

        //在ans里的数字是倒着的，所以string要从最后开始加
        String str = "";
        while (i >= 0) {
            str += ans[i--];
        }
        return str;
    }

    public static void main(String[] args){
        MultiplyString solution = new MultiplyString();
        String res = solution.multiply("123","21");
        System.out.println(res);
    }
}
