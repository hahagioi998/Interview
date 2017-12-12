package binarytree.LCA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lca4 {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }
    private TreeNode helper(TreeNode node, Set<TreeNode> nodes) {
        if (node == null) {
            return null;
        }
        if (nodes.contains(node)) {
            return node;
        }
        TreeNode left = helper(node.left, nodes);
        TreeNode right = helper(node.right, nodes);

        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }
}
