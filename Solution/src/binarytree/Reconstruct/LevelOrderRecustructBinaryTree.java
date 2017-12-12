package binarytree.Reconstruct;


import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderRecustructBinaryTree {
    public TreeNode construct(int[] level) {
        //How to re construct a complete binary tree from its level-order traversal sequence only.
        
        if(level == null || level.length == 0){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(level[0]);
        queue.offer(root);

        for(int i = 1; i < level.length; i++){
            if(queue.peek().left != null && queue.peek().right != null){
                queue.poll();
            }
            TreeNode cur = queue.peek();

            if(cur.left == null){
                cur.left = new TreeNode(level[i]);
                queue.offer(cur.left);
            }else{
                cur.right = new TreeNode(level[i]);
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
