package String.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//用i - s.length()
//l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
public class AllAnagrams {
    //assume s,l are not null, s is not empty
    List<Integer> allAnagrams(String s, String l) {
        //这个sliding window长度就是s.length()是通过i和s.length()来构建的
        // i没加1，对应的char个数就减1，查看是否match
        // i>=s.length()，i-s.length()的char个数就加1，查看是否match
        List<Integer> res = new ArrayList<>();
        if(l.length() == 0){
            return res;
        }

        if(s.length() > l.length()){
            return res;
        }

        //重点是distinct characters！
        Map<Character, Integer> map = countMap(s);
        //record how many distinct characters have been matched.
        //only when all the distinct characters are matched
        //match == map.size(), we find an anagram
        //match每一个char，所以只有在count=1的时候才算match
        int match = 0;
        //we have a sliding window of size s.length()
        //we only need to record the end index
        //also when move the sliding window by one step from left to right
        //what we only need to change is
        //1. remove the leftmost character at the previous sliding window
        //2. add the rightmost character at the current sliding window
        for(int i = 0; i < l.length(); i++){

            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            //每找到一个数字就减掉
            if(count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    //只是这个char的match
                    match++;
                }
            }

            if( i >= s.length()){
                //前一个sliding window的开始, 在map里加回去，match也要减掉
               tmp = l.charAt(i - s.length());

               count = map.get(tmp);
               //要查看count是不是null，因为可能不是想要找的char
               if(count != null){
                   map.put(tmp, count + 1);
                   //如果count = 0所以要把match也减掉
                   if(count == 0){
                       match--;
                   }
               }
            }

            //all distinct chars are matched
            if(match == map.size()){
                res.add(i - s.length() + 1);
            }

        }
        return res;

    }

    private Map<Character, Integer> countMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }
}
