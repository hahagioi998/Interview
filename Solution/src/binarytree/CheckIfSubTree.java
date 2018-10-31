package binarytree;

public class CheckIfSubTree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        //root is the same
        // if(T1.val == T2.val){
        //     return helper(T1.left, T2.left) && helper(T1.right, T2.right);
        // }
        if(isEqual(T1, T2)){
            return true;
        }

        //在identical tree增加了这一步，就是子节点再去比较
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    private boolean isEqual(TreeNode T1, TreeNode T2){
        if(T1 == null && T2== null){
            return true;
        }

        if(T1 == null || T2 == null){
            return false;
        }
        if(T1.key == T2.key){
            return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
        }else{
            return false;
        }

    }
}
