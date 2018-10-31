package binarytree.MaximumPath;

/*
 preorder traversal means doing something at cur node first and pass down
 postorder and inorder meaning you have to go all the way to the left
 postorder meaning must collect return, e.g. must know how many nodes, from left and right before you an do something
 */

//path is the no of nodes and their values
//we'll not know path untill we get values from left and right, so this is a postorder traversal
// when we need values from left and right, we need to consider if we have left and right
// local processing, meaning two children and one child will make a difference when nodes value could be negative!!


public class FindMinDepth {
    //for min depth, two children and one children and nochildren will be different
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //不是叶节点
        if(root.left != null && root.right != null){

            //return local min，当有两个子树的时候
            return Math.min(left, right) + 1;
        }

        //meaning two children and one child will make a difference when nodes value could be negative!!
        return root.left == null? right + 1 : left + 1;
    }
}
