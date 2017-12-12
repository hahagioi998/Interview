package binarytree.MaximumPath;

/*
 preorder traversal means doing something at cur node first and pass down
 postorder and inorder meaning you have to go all the way to the left
 postorder meaning must collect return, e.g. must know how many nodes, from left and right before you an do something
 */

//path is the no of nodes and their values
//we'll not know path untill we get values from left and right, so this is a postorder traversal
// when we need values from left and right, we need to consider if we have left and right
// local processing, meaning two children and one child will make a difference when minimum matters, e.g. nodes value could be negative!!

public class MPS2 {
    public int maxPathSum(TreeNode root) {
        // path to anynode
        //not taking negative sum into consideraion

        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode node, int[] max){
        if(node == null){ //we can reach leaves
            return 0;
        }

        int left = helper(node.left, max);
        int right = helper(node.right, max);

        left = left < 0? 0 : left;//discard path when sum becomes negative
        right = right < 0 ? 0 : right;

        // global max max[0] = Math.max(max[0], node.key);//not asking children node when children node are negative
        max[0] = Math.max(node.key + left + right, max[0]);


        // return local max
        //discard all negative so we don't need local processing, minimum is just 0
        return Math.max(left, right) + node.key;
    }
}
