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


public class FindHeight {
    //consider there are two children， one child， no children
    public int findHeight(TreeNode root) {
        // reach leaves
        if(root == null){
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        //minimum is always 0
        // local max is global max, select one path
        return Math.max(left, right) + 1;
    }
}
