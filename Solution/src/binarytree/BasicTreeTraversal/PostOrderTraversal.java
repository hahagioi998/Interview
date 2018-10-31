package binarytree.BasicTreeTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postOrder(Node root) {
        // Write your solution here.
        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node != null) {
                res.addFirst(node.data);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return res;
    }
}
