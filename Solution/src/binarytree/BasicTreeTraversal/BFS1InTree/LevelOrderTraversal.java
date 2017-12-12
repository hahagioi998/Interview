package binarytree.BasicTreeTraversal.BFS1InTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public void levelOrder(Node root){
        if(root == null){
            System.out.println("Please enter a valid tree!");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        System.out.println();

        while(queue.size() > 0){
            root = queue.poll();
            System.out.print(root.data + " ");

            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
    }
}
