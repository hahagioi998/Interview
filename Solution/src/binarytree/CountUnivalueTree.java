package binarytree;
/**
 * Given a binary tree, count the number of uni-value subtrees.
         * A Uni-value subtree means all nodes of the subtree have the same value.
         *
         * https://leetcode.com/problems/count-univalue-subtrees/
         */
 class CountUnivalueTree {
    //global value
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        countUnivalSubtreesUtil(root, 0);
        return count;
    }

    private int countUnivalSubtreesUtil(TreeNode root, int val) {
        if (root == null) {
            //返回root的data
            return val;
        }

        //到最后才能判断，当前的node和它的子树是可以知道的
        int left = countUnivalSubtreesUtil(root.left, root.key);
        int right = countUnivalSubtreesUtil(root.right, root.key);
        if (left == right && left == root.key) {
            count++;
            return root.key;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
           /* Let us construct the below tree
                5
              /   \
            4      5
          /  \      \
         4    4      5 */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        CountUnivalueTree sol = new CountUnivalueTree();
        System.out.println("The count of single valued sub trees is : "
                + sol.countUnivalSubtrees(root));
    }
}
