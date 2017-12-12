package binarytree;

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return true;
        }
        //一开始就只是root的左和右
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.key != right.key) {
            return false;
        }
        //不同方向
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
