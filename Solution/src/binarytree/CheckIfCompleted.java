package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here.
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;//boolean flag
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(cur.left == null){ //end of left substree
                flag = true;
            }else if(flag){ //can't have more left child if it's end of left substree
                return false;
            }else{ //offer all left children
                queue.offer(cur.left);
            }

            if(cur.right == null){ //no right child
                flag = true;
            }else if(flag){ // can't have right child if there's no more left/right child
                return false;
            }else{
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
