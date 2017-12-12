package DFS.Permutation;

import java.util.ArrayList;
import java.util.List;

//use permutation when the resulting array contains all chars of the original one
//each level represtents position(index) to put
public class PermutationI {
    public List<String> permutations(String set) {
        // Write your solution here.
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

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            helper(chars, index + 1, res);
            swap(chars, index, i);
        }
    }
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        boolean[] B = new boolean[A.length];
        PermutationI i = new PermutationI();
        System.out.println(i.permutations("12345"));
    }
}
