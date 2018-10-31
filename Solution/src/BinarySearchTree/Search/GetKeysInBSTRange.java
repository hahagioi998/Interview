package BinarySearchTree.Search;


import java.util.ArrayList;
import java.util.List;
//preorder也可以，但使用了inorder，可以得到递增的序列，未必都在一个level
public class GetKeysInBSTRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        helper(root, min, max, res);
        return res;
    }

    private void helper(TreeNode node, int min, int max, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.key >= min) {
            helper(node.left, min, max, res);
        }
        if (node.key >= min && node.key <= max) {
            res.add(node.key);
        }
        if (node.key <= max) {
            helper(node.right, min, max, res);
        }
    }
}
