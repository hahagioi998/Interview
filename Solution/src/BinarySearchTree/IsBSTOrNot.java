package BinarySearchTree;

public class IsBSTOrNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here.

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.key <= min || node.key >= max) {
            return false;
        }
        //min and max is different for left child and right child
        return helper(node.left, min, node.key) && helper(node.right, node.key, max);
    }
}
