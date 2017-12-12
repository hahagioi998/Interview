package String.Calculation;

import java.util.HashSet;
import java.util.Set;
//对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。如果可以变为1，那么这个数就是快乐数。
public class HappyNumber {
    public boolean isHappy(int n) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        int temp = 0;
        Integer nn = new Integer(n);

        while(nn != 1){//看最后能不能到1
            if(set.contains(nn)) return false;
            set.add(nn);
            temp = nn;

            nn = 0;
            while(temp != 0){
                nn += (temp%10)*(temp%10);
                temp = temp / 10;
            }
        }
        return true;
    }
}
