package binarytree.MaximumPath;

/*
 preorder traversal means doing something at cur node first and pass down
 postorder and inorder meaning you have to go all the way to the left
 postorder meaning must collect return from left and right before you an do something
 */

//path is the no of nodes，找最长的节点链
//we'll not know path untill we get values from left and right, so this is a postorder traversal
// when we need values from left and right, we need to consider if minimum is unknown

//The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.
public class BinaryTreeDiameter {
    public int diameter(TreeNode root) {
        //For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
        int[] max = new int[]{0};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max){
        if (root == null) { //base case is where recursion ends, meaning where the path can reach
            return 0;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        //make sure you have both the left and right nodes, because it's leaf to leaf, root not consider as leaf here
        if (root.left != null && root.right != null) {
            //update global max
            max[0] = Math.max(left + right + 1, max[0]);
        }

        // local max
        return Math.max(left, right) + 1;
    }
}
