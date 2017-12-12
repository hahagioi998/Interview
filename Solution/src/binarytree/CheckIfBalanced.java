package binarytree;

public class CheckIfBalanced {
    public boolean isBalanced(TreeNode root) {
        // Write your solution here.
        if (root == null) {return true;}
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode node) {
        if (node == null) {return 0;}
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
