package BinarySearchTree.Search;


public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        //如果key比左边界小，那就返回右子树的root
        if (root.key < L) {
            //这里是因为当前的root不在范围内，所以root不可用，要去右边找到在范围内的并且返回
            return trimBST(root.right, L, R);
        }
        if (root.key > R) {
            return trimBST(root.left, L, R);
        }

        //这个是在range内，确认这个链接
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        //每一层都会返回的在范围内的当前的值
        return root;
    }
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