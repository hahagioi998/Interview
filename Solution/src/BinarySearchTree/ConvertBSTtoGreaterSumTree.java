package BinarySearchTree;


//用inorder traversal，但是是postorder的思想
//先向右走走到底，返回的时候再做处理！！注意是返回的时候
public class ConvertBSTtoGreaterSumTree {
    int sum = 0;

    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        //这是不包括自己的解法
        dfs(cur.right);

        int copy = cur.key;
        cur.key = sum;
        sum += copy;

        dfs(cur.left);

        //这是sum包括自己的解法
//        dfs(cur.right);
//        sum += cur.key;
//        cur.key = sum;
//        dfs(cur.left);
    }

    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        dfs(root);
        return root;
    }
}
