package binarytree;

public class IdentitcalBinaryTree {
    public boolean isIdentical(TreeNode one, TreeNode two) {
        // Write your solution here.
        if(one == null && two == null){
            return true;
        }

        if(one == null || two == null){
            return false;
        }

        if(one.key == two.key){
            //同样的顺序
            return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
        }else{//not equal
            return false;
        }
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
