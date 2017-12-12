package String.Calculation;
//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
public class AddDigits {
    public int addDigits(int num) {

        if (num == 0) {

            return 0;

        }

        int ans = 0;

        for (; num != 0; ) {

            int digit = num % 10;

            ans = (ans * 10 + digit) % 9;

            num /= 10;

        }

        return ans == 0 ? 9 : ans;

//        int sum = num;
//        while(sum >= 10){ //确保是个位数
//            sum = 0;
//            while(num > 0){ //把num都加掉
//                sum += num % 10;
//                num = num / 10;
//            }
//            num = sum; //更新num
//        }
//        return sum;


    }

    public static void main(String[] args){
        AddDigits solution = new AddDigits();
        System.out.println(solution.addDigits(738));
    }
}
