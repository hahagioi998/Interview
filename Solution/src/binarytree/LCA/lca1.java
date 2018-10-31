package binarytree.LCA;
//ganranteed to be in the tree
public class lca1 {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // Write your solution here.
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}