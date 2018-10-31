package binarytree.BasicTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public List<Integer> preOrder(Node root) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);//can push root first

        while (!stack.isEmpty()) {
            Node node = stack.pop();//root

            //想想只有三个node，根左右的话要怎么放
            //node有可能会有是null，因为有的node可能只有一个子节点
            if (node != null) {
                //root，只在到root的时候加入到过list里
                res.add(node.data);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
