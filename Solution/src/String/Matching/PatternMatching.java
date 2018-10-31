package String.Matching;

import java.util.HashMap;
import java.util.Map;
/*
Given a pattern and a string input - find if the string follows the same pattern and return true or false.

Examples:

Pattern : "abab", input: "redblueredblue" should return true.
Pattern: "aaaa", input: "asdasdasdasd" should return true.
Pattern: "aabb", input: "xyzabcxzyabc" should return false.
 */
//学到当运用到对应关系的时候要用hashmap
public class PatternMatching {
    public boolean isMatch(String str, String pat) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(str, 0, pat, 0, map);
    }

    //pattern是比较短的
    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            //要么太长了，要么不match
            if (i + s.length() > str.length() || !str.substring(i, i + s.length()).equals(s)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            //pattern只需要+1，因为p的个字符可以match string的好多歌字符
            return isMatch(str, i + s.length(), pat, j + 1, map);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            // create or update the map
            //hashmap会覆盖同样的key的value
            //这里i是固定，就是起点，但是k会改变
            map.put(c, str.substring(i, k + 1));

            // continue to match the rest
            //注意这里是k+1
            if (isMatch(str, k + 1, pat, j + 1, map)) {
                return true;
            }
        }

        // we've tried our best but still no luck
        map.remove(c);

        return false;
    }
}
