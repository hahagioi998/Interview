package DFS;

import java.util.ArrayList;
import java.util.List;

public class ValidPermutationOfParenthesis {
    public List<String> validParentheses(int n) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, "", res);
        return res;
    }
    private void helper(int n, int left, int right, String sb, List<String> res) {
        if (left + right == n * 2) {
            res.add(sb);
            return;
        }
        if (left < n) {
            helper(n, left + 1, right, sb + "(", res);
        }
        if (right < left) {
            helper(n, left, right + 1, sb + ")", res);
        }
    }
}
