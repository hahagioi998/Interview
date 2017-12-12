package String.SlidingWindow;

import java.util.HashSet;
import java.util.Set;
//For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
public class LongestSubstringWithoutRepeatingChar {
    public int longest(String input) {
        // Write your solution here.
        // create a sliding window between fast and slow
        if(input.length() == 0){
            return 0;
        }
        //set只！用来记substring sliding window里出现的char
        Set<Character> set = new HashSet<>();
        //用fast和slow ptr来创造一个区域，都从第一个index开始走
        int slow = 0;
        int fast = 0;
        int res = 0;
        while(fast < input.length()){
            //先看fast有没有在set里,每次都看fast有没有在set里
            if(!set.contains(input.charAt(fast))){
                //演出这个string
                set.add(input.charAt(fast));
                fast++;
                //算substring的长度，因为fast++了，所以这里不需要-1
                res = Math.max(res, fast - slow);
            }else{
                //如果fast出现在set里了，也就是说fast是一个当前substring里的repeat char，就要缩减这个set
                set.remove(input.charAt(slow));
                slow++;//move slow until there's no duplicates of fast
            }
        }

        return res;
    }
}
