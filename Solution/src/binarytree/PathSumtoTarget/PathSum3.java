package binarytree.PathSumtoTarget;

/*
 preorder traversal means doing something at cur node first and go LEFT FRST!!
 postorder and inorder meaning you have to go all the way to the LEFT FIRST!!
 postorder meaning must collect return, e.g. must know how many nodes, from left and right before you an do something
 */

//we can choose to discard the previous sum

// preorder
public class PathSum3 {
    public boolean exist(TreeNode root, int target) {
        if(root == null) {
            return false;
        }

        return helper(root, 0, target);
    }

    private boolean helper(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }
        if (sum + root.key == target) {
            return true;
        }
        return helper(root.left, root.key, target) || helper(root.left, sum + root.key, target)
                || helper(root.right, root.key, target) || helper(root.right, sum + root.key, target);
    }

    //NOT RIGHT, because we at least need to remove root.key from cur root, so target will always be changed,
    //unless we can skip nodes

//    private boolean helper(TreeNode root, int target) {
//        if (root == null) {// reach after leaf would be false, because we check before it reaches leaf
//            return false;
//        }
//
//        if(target - root.key == 0){
//            return true;
//        }
//
//        return helper(root.left, target - root.key) || helper(root.right, target - root.key) ||
// helper(root.left, target) || helper(root.right, target);
//    }
}
