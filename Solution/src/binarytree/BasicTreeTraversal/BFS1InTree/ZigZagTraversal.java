package binarytree.BasicTreeTraversal.BFS1InTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// [5, 3, 8, 11, 4, 1]
public class ZigZagTraversal {
    public List<Integer> zigZag(TreeNode root) {
        //make it work like double end queue, so FIFO on both end
        //  5 (pull -> 5)(offer -> 8 3)even pullLast, offerFirst add right and left child
        // (pull <- 3 8) 3 8 (offer <- 1 4 11)  then odd pullFirst, offerLast
        // (pull-> 11 4 1) (offer -> )1 4 11
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;

        while(!deque.isEmpty()){
            int size = deque.size();

            for(int i = 0; i < size; i++){
                if(layer % 2 == 0){//even layer
                    TreeNode cur = deque.pollLast();
                    res.add(cur.key);

                    if(cur.right != null){//need to check if it is null
                        deque.offerFirst(cur.right); //right is offered first
                    }
                    if(cur.left != null){
                        deque.offerFirst(cur.left);
                    }
                }else{//odd layer
                    TreeNode cur = deque.pollFirst(); //because offered first in even layer
                    res.add(cur.key);
                    if(cur.left != null){//need to check if it is null
                        deque.offerLast(cur.left); //
                    }
                    if(cur.right != null){
                        deque.offerLast(cur.right);
                    }
                }
                //
            }
            layer++;//increment layer when deque is empty
        }
        return res;
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