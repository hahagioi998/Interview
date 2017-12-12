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

            if (node != null) {//until reach null
                //root，只在到root的时候加入到过list里
                res.add(node.data);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
