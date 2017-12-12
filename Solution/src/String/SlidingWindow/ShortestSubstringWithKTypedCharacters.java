package String.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
If the length of string is n, then there can be n*(n+1)/2 possible substrings. A simple way is to generate all the substring and check each one whether it has exactly k unique characters or not. If we apply this brute force, it would take O(n2) to generate all substrings and O(n) to do a check on each one. Thus overall it would go O(n3).

        We can further improve this solution by creating a hash table and while generating the substrings, check the number of unique characters using that hash table. Thus it would improve up to O(n2).
The problem can be solved in O(n).
*/
/*
input = "aabcc", k = 3, output = "abc".
        input = "aabbbcccc", k = 3, output = "abbbc".
        input = "aabcc", k = 4, output = "".*/
public class ShortestSubstringWithKTypedCharacters {
//    public String shortest(String s, int k) {
//        int maxLen = 0;
//
//        // Key: letter; value: the number of occurrences.
//        Map<Character, Integer> map = new HashMap<>();
//        int i, j = 0;
//        char c;
//        for (i = 0; i < s.length(); i++) {
//            while (j < s.length()) {
//                c = s.charAt(j);
//                if (map.containsKey(c)) {
//                    map.put(c, map.get(c) + 1);
//                } else {
//                    if(map.size() ==k)
//                        break;
//                    map.put(c, 1);
//                }
//                j++;
//            }
//
//            maxLen = Math.max(maxLen, j - i);
//            c = s.charAt(i);
//            if(map.containsKey(c)){
//                int count = map.get(c);
//                if (count > 1) {
//                    map.put(c, count - 1);
//                } else {
//                    map.remove(c);
//                }
//            }
//        }
//        return maxLen;}



    public static void main(String[] args){
        ShortestSubstringWithKTypedCharacters s = new ShortestSubstringWithKTypedCharacters();
//        String res = s.shortest("aabbbccc", 3);
//        System.out.println(res);
    }
}
