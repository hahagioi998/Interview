package DFS.Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] chars = set.toCharArray();
        helper(chars, 0, res);
        return res;
    }
    private void helper(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
            res.add(String.valueOf(chars));
        }
        Set<Character> set = new HashSet<>();//每一层，不要在同一个位置try同样的char
        for (int i = index; i < chars.length; i++) {
            if (set.add(chars[i])) { //如果可以加进去，则表示没有用过
                swap(chars, index, i);
                helper(chars, index + 1, res);
                swap(chars, index, i);
            }
        }
    }
    private void swap(char[] array, int left, int right){
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
