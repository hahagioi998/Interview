package binarytree;

public class TweakedBinaryTree {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here.
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        }
        if (one.key != two.key) {
            return false;
        }
        return isTweakedIdentical(one.left, two.left) &&  isTweakedIdentical(one.right, two.right)
                || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }
}
