package binarytree.BasicTreeTraversal.BFS1InTree;


import java.util.LinkedList;
import java.util.Queue;

//BFS in tree
//同一层的考虑用BDS1 queue, level order traversal
//complete binary tree means absence of node is only allowed on the last level
// think about on the same level, we want to fill left child first
// no more left child means no more right child
// no more right child means end of tree
public class CheckComplete {
    public boolean isCompleted(TreeNode root) {
        //if the flag is set to true, there should be no child afterwards

        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //flag marks the leaf node that is
        boolean flag = false;

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            // if any child is not present, set flag to true
            if(cur.left == null){ //on the same level, no left child marks end of tree
                flag = true;
            }else if(flag){ // no right child (upper level) means no more left child(lower level)
                return false;
            }else{ //left child exists
                queue.offer(cur.left);
            }

            if(cur.right == null){ //on the same level, no more right child means end of tree
                flag = true;
            }else if(flag){ // no left child means no more right child
                return false;
            }else{// left exits and right exists
                queue.offer(cur.right);
            }
        }
        return true;
    }


}
class Node {
    int data;
    Node left;
    Node right;
    Node next;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}