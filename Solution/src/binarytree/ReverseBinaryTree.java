package binarytree;

public class ReverseBinaryTree {
    public TreeNode reverse(TreeNode root) {
        if(root == null){
            return root;
        }
        // Write your solution here.
        if(root.left == null){
            return root;
        }

        TreeNode newRoot = reverse(root.left);
        root.left.left = root;//root.left is newRoot at the bottom
        root.left.right = root.right;
        root.left = null;//have to set them null
        root.right = null;
        return newRoot;

        //need to know iterative method also
    }
}
