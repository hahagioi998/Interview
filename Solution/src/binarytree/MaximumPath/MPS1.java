package binarytree.MaximumPath;

/*
 preorder traversal means doing something at cur node first and pass down
 postorder and inorder meaning you have to go all the way to the left
 postorder meaning must collect return, e.g. must know how many nodes, from left and right before you an do something
 */
// MPS1 is the path from one leaf to another lead that contain maximum value
//path is the no of nodes and their values
//we'll not know path untill we get values from left and right, so this is a postorder traversal
// when we need values from left and right, we need to consider if we have left and right
// local processing, meaning two children and one child will make a difference when minimum matters, e.g. nodes value could be negative!!

public class MPS1 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Write your solution here.
        // int max = Integer.MIN_VALUE;
        // taking negative sums in to consideration

        helper(root);
        return max;
    }
    private int helper(TreeNode node) {
        if (node == null ) { //base case
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        // can't do left !=null because and function returns actual value
        // because minimum is unknow, we need to check left and right nodes
        if (node.left != null && node.right != null) {
            // update global max
            max = Math.max(max, left + right + node.key);
            // return local max, 两个子树都在的时候
            return Math.max(left, right) + node.key;
        }

        // meaning two children and one child will make a difference when minimum matters,
// e.g. nodes value could be negative!! minimum is unknown
        //特殊情况，只有一个子树的时候
        return node.left == null ? node.key + right : node.key + left;
    }
}

class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.key = data;
        left = null;
        right = null;
    }
}