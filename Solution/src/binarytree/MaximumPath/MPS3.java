package binarytree.MaximumPath;
/*
 preorder traversal means doing something at cur node first and pass down
 postorder and inorder meaning you have to go all the way to the left
 postorder meaning must collect return, e.g. must know how many nodes, from left and right before you an do something
 */

//path is the sum of nodes values
//we'll not know path untill we get values from left and right, so this is a postorder traversal
// when we need values from left and right, we need to consider if we have left and right
// local processing, meaning two children and one child will make a difference when minimum matters, e.g. nodes value could be negative!!

//doesn't have to start from root or reach leaf, but should be on the same path
public class MPS3 {
    public int maxPathSum(TreeNode root) {
        // Write your solution here.
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        helper(root, maxSum);
        return maxSum[0];
    }

    private int helper(TreeNode root, int[] maxSum){
        if(root == null){
            return 0;
        }

        int left = helper(root.left, maxSum);
        int right = helper(root.right, maxSum);

        left = left < 0 ? 0 : left;
        right = right < 0? 0 : right;

        // only select one path, global max
        maxSum[0] = Math.max(Math.max(left, right) + root.key, maxSum[0]);

        //minimum is known, local max
        return Math.max(right, left) + root.key;
    }
}
