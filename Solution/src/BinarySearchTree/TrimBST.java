package BinarySearchTree;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        //如果key比左边界小，那就返回右子树的root
        if (root.key < L) {
            return trimBST(root.right, L, R);
        }
        if (root.key > R) {
            return trimBST(root.left, L, R);
        }

        //这个是在range内，左右找
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        //返回root
        return root;
    }
}
