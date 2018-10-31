package binarytree.PathSumtoTarget;

/*
 preorder traversal means doing something at cur node first and pass to LEFT FIRST!!!
 postorder and inorder meaning you have to go all the way to the LEFT FIRST!!
 postorder meaning must collect return from left and right before you an do something
 */

// we need to use preorder for this problem
// leaf node is root.left == null && root.right == null

public class PathSum1 {
    public boolean exist(TreeNode root, int target) {
        if (root == null) { // reach after leaf would be false, because we check before it reaches leaf
            //单一节点的时候，就放弃这条线
            return false;
        }
        if(root.left == null && root.right == null && target - root.key == 0) {
            return true;
        }
        return exist(root.left, target - root.key) || exist(root.right, target - root.key);
    }

    //INCORRECT, because it GO TO LEFT FIRST!!
//    public boolean exist(TreeNode root, int target) {
//        if (root == null) {// we can't do this, because now roo
//            return target == 0; // plus target has to be 0
//        }
//
//        target -= root.key;
//        return (exist(root.left, target) && exist(root.right, target));
//    }
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